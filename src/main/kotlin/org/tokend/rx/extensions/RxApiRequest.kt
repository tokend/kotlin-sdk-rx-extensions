@file:JvmName("RxApiRequest")

package org.tokend.rx.extensions

import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import org.tokend.sdk.api.base.ApiRequest

/**
 * Creates a lazy [Single] from request's clone, which will be
 * executed on subscription and can be canceled by disposing.
 */
fun <T> ApiRequest<T>.toSingle(): Single<T> = Single.create<T> { emitter ->
    val request = clone()
    var isDisposed = false

    emitter.setDisposable(object : Disposable {
        override fun isDisposed() = isDisposed

        override fun dispose() {
            request.cancel()
            isDisposed = true
        }
    })

    try {
        val response = request.execute()
        if (!isDisposed) {
            try {
                emitter.onSuccess(response.get())
            } catch (e: Throwable) {
                emitter.tryOnError(e)
            }
        }
    } catch (e: Throwable) {
        if (!isDisposed) {
            emitter.tryOnError(e)
        }
    }
}

/**
 * Creates a lazy [Completable] from request's clone, which will be
 * executed on subscription and can be canceled by disposing.
 */
fun ApiRequest<Void>.toCompletable() = Completable.create { emitter ->
    val request = clone()
    var isDisposed = false

    emitter.setDisposable(object : Disposable {
        override fun isDisposed() = isDisposed

        override fun dispose() {
            request.cancel()
            isDisposed = true
        }
    })

    try {
        request.execute()
        if (!isDisposed) {
            emitter.onComplete()
        }
    } catch (e: Throwable) {
        if (!isDisposed) {
            emitter.tryOnError(e)
        }
    }
}