package org.tokend.rx.streamer

import org.tokend.sdk.api.base.ApiRequest
import org.tokend.sdk.api.base.model.DataPage
import java.util.function.Predicate

class SimpleRxPagedResourceStreamer<T>(
        private val requestProvider: (nextCursor: String?) -> ApiRequest<DataPage<T>>,
        private val fatalErrorPredicate: Predicate<Throwable> = Predicate { false },
        override val pollIntervalMs: Long = DEFAULT_POLL_INTERVAL_MS,
        override val retryTimeoutMs: Long = DEFAULT_RETRY_TIMEOUT_MS
): RxPagedResourceStreamer<T>() {
    override fun getPageRequest(nextCursor: String?) =
            requestProvider.invoke(nextCursor)

    override fun isErrorFatal(error: Throwable) =
            fatalErrorPredicate.test(error)
}