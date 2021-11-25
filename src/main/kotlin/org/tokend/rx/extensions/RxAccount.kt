@file:JvmName("RxAccount")

package org.tokend.rx.extensions

import io.reactivex.Single
import org.tokend.wallet.Account

/**
 * @see Account.random
 */
fun Account.Companion.randomSingle(): Single<Account> {
    return Single.defer {
        Single.just(random())
    }
}

/**
 * @see Account.fromSecretSeed
 */
fun randomSingle(): Single<Account> {
    return Account.randomSingle()
}

/**
 * @see Account.fromSecretSeed
 */
fun Account.Companion.fromSecretSeedSingle(seed: CharArray): Single<Account> {
    return Single.defer {
        Single.just(fromSecretSeed(seed))
    }
}

/**
 * @see Account.fromSecretSeed
 */
fun fromSecretSeedSingle(seed: CharArray): Single<Account> {
    return Account.fromSecretSeedSingle(seed)
}

/**
 * @see Account.fromSecretSeed
 */
fun Account.Companion.fromSecretSeedSingle(seed: ByteArray): Single<Account> {
    return Single.defer {
        Single.just(fromSecretSeed(seed))
    }
}

/**
 * @see Account.fromSecretSeed
 */
fun fromSecretSeedSingle(seed: ByteArray): Single<Account> {
    return Account.fromSecretSeedSingle(seed)
}
