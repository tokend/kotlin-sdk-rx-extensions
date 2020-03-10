@file:JvmName("RxApiRequest")

package org.tokend.rx.extensions

import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import org.tokend.sdk.api.base.ApiRequest

/**
 * Converts given request to a lazy [Single].
 * Source request will be executed on subscription
 * and can be canceled by disposing it.
 */
fun <T> ApiRequest<T>.toSingle(): Single<T> = Single.create<T> { emitter ->
    val request = this
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
 * Converts given request with no result to a lazy [Completable].
 * Source request will be executed on subscription
 * and can be canceled by disposing it.
 */
fun ApiRequest<Void>.toCompletable() = Completable.create { emitter ->
    val request = this
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