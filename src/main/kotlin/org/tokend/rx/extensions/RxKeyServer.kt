@file:JvmName("RxKeyServer")

package org.tokend.rx.extensions

import io.reactivex.Single
import org.tokend.sdk.keyserver.KeyServer
import org.tokend.sdk.keyserver.models.KdfAttributes
import org.tokend.sdk.keyserver.models.SignerData
import org.tokend.sdk.keyserver.models.WalletCreateResult
import org.tokend.wallet.Account
import org.tokend.wallet.NetworkParams
import org.tokend.wallet.Transaction
import org.tokend.wallet.xdr.Uint64

/**
 * @see KeyServer.createWallet
 */
@JvmOverloads
@JvmName("_createWalletSingle")
fun KeyServer.Companion.createWalletSingle(
        email: String,
        password: CharArray,
        kdfAttributes: KdfAttributes,
        kdfVersion: Long,
        defaultSignerRole: Uint64,
        rootAccount: Account = Account.random()
): Single<WalletCreateResult> {
    return Single.defer {
        Single.just(createWallet(email, password, kdfAttributes, kdfVersion, defaultSignerRole, rootAccount))
    }
}

/**
 * @see KeyServer.createWallet
 */
@JvmOverloads
fun createWalletSingle(
        email: String,
        password: CharArray,
        kdfAttributes: KdfAttributes,
        kdfVersion: Long,
        defaultSignerRole: Uint64,
        rootAccount: Account = Account.random()
): Single<WalletCreateResult> {
    return KeyServer.createWalletSingle(email, password, kdfAttributes, kdfVersion, defaultSignerRole, rootAccount)
}

/**
 * @see KeyServer.createWallet
 */
@JvmName("_createWalletSingle")
fun KeyServer.Companion.createWalletSingle(
        email: String,
        password: CharArray,
        kdfAttributes: KdfAttributes,
        kdfVersion: Long,
        rootAccount: Account,
        signers: Collection<SignerData>
): Single<WalletCreateResult> {
    return Single.defer {
        Single.just(createWallet(email, password, kdfAttributes, kdfVersion, rootAccount, signers))
    }
}

/**
 * @see KeyServer.createWallet
 */
fun createWalletSingle(
        email: String,
        password: CharArray,
        kdfAttributes: KdfAttributes,
        kdfVersion: Long,
        rootAccount: Account,
        signers: Collection<SignerData>
): Single<WalletCreateResult> {
    return KeyServer.createWalletSingle(email, password, kdfAttributes, kdfVersion, rootAccount, signers)
}

/**
 * @see KeyServer.createSignersUpdateTransaction
 */
@JvmName("_createSignersUpdateTransactionSingle")
fun KeyServer.Companion.createSignersUpdateTransactionSingle(
        networkParams: NetworkParams,
        originalAccountId: String,
        currentAccount: Account,
        signers: Collection<SignerData>,
        newAccount: Account,
        defaultSignerRole: Uint64): Single<Transaction> {
    return Single.defer {
        Single.just(createSignersUpdateTransaction(networkParams, originalAccountId, currentAccount,
                signers, newAccount, defaultSignerRole))
    }
}

/**
 * @see KeyServer.createSignersUpdateTransaction
 */
fun createSignersUpdateTransactionSingle(
        networkParams: NetworkParams,
        originalAccountId: String,
        currentAccount: Account,
        signers: Collection<SignerData>,
        newAccount: Account,
        defaultSignerRole: Uint64): Single<Transaction> {
    return KeyServer.createSignersUpdateTransactionSingle(networkParams, originalAccountId, currentAccount,
            signers, newAccount, defaultSignerRole)
}