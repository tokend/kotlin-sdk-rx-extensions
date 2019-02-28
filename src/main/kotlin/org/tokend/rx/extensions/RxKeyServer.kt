@file:JvmName("RxKeyServer")

package org.tokend.rx.extensions

import io.reactivex.Single
import org.tokend.sdk.keyserver.KeyServer
import org.tokend.sdk.keyserver.models.KdfAttributes
import org.tokend.sdk.keyserver.models.LoginParams
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
        rootAccount: Account = Account.random(),
        recoveryAccount: Account = Account.random()
): Single<WalletCreateResult> {
    return Single.defer {
        Single.just(createWallet(email, password, kdfAttributes, kdfVersion, rootAccount, recoveryAccount))
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
        rootAccount: Account = Account.random(),
        recoveryAccount: Account = Account.random()
): Single<WalletCreateResult> {
    return KeyServer.createWalletSingle(email, password, kdfAttributes, kdfVersion, rootAccount, recoveryAccount)
}

/**
 * @see KeyServer.createWallet
 */
@JvmOverloads
@JvmName("_createWalletSingle")
fun KeyServer.Companion.createWalletSingle(
        email: String,
        password: CharArray,
        loginParams: LoginParams,
        rootAccount: Account = Account.random(),
        recoveryAccount: Account = Account.random()
): Single<WalletCreateResult> {
    return Single.defer {
        Single.just(createWallet(email, password, loginParams, rootAccount, recoveryAccount))
    }
}

/**
 * @see KeyServer.createWallet
 */
@JvmOverloads
fun createWalletSingle(
        email: String,
        password: CharArray,
        loginParams: LoginParams,
        rootAccount: Account = Account.random(),
        recoveryAccount: Account = Account.random()
): Single<WalletCreateResult> {
    return KeyServer.createWalletSingle(email, password, loginParams, rootAccount, recoveryAccount)
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
        defaultSignerRole: Uint64,
        defaultSignerDetailsJson: String): Single<Transaction> {
    return Single.defer {
        Single.just(createSignersUpdateTransaction(networkParams, originalAccountId, currentAccount,
                signers, newAccount, defaultSignerRole, defaultSignerDetailsJson))
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
        defaultSignerRole: Uint64,
        defaultSignerDetailsJson: String): Single<Transaction> {
    return KeyServer.createSignersUpdateTransactionSingle(networkParams, originalAccountId, currentAccount,
            signers, newAccount, defaultSignerRole, defaultSignerDetailsJson)
}