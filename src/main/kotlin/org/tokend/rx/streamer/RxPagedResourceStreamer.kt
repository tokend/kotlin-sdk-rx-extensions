package org.tokend.rx.streamer

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import org.tokend.sdk.utils.streamer.PagedResourceStreamer
import java.util.concurrent.atomic.AtomicInteger

abstract class RxPagedResourceStreamer<T>: PagedResourceStreamer<T>() {
    protected val itemsSubject = PublishSubject.create<List<T>>()

    protected var subscribersCount = AtomicInteger()

    /**
     * Emits new items and fatal error if it's occurred.
     *
     * Resumes streaming on first subscription and stops it on last disposal
     *
     * @see resumeStreaming
     * @see stopStreaming
     */
    open val observable: Observable<List<T>> = itemsSubject
            .doOnSubscribe {
                if (subscribersCount.incrementAndGet() == 1) {
                    resumeStreaming()
                }
            }
            .doOnDispose {
                if (subscribersCount.decrementAndGet() == 0) {
                    stopStreaming()
                }
            }

    override fun onNewItems(newItems: List<T>) =
            itemsSubject.onNext(newItems)

    override fun onFatalError(e: Throwable) {
        super.onFatalError(e)
        itemsSubject.onError(e)
    }
}