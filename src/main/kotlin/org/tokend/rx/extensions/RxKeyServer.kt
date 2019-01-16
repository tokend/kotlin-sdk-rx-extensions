@file:JvmName("RxKeyServer")

package org.tokend.rx.extensions

import io.reactivex.Completable
import io.reactivex.Single
import org.tokend.sdk.keyserver.KeyServer
import org.tokend.sdk.keyserver.models.*
import org.tokend.wallet.Account
import org.tokend.wallet.NetworkParams
import org.tokend.wallet.Transaction

/**
 * @return lazy [Single] with wallet info request result
 *
 * @see KeyServer.getWalletInfo
 */
@JvmOverloads
fun KeyServer.getWalletInfoSingle(login: String,
                                  password: CharArray,
                                  isRecovery: Boolean = false): Single<WalletInfo> {
    return Single.defer {
        Single.just(getWalletInfo(login, password, isRecovery))
    }
}

/**
 * @return lazy [Single] with login params request result
 *
 * @see KeyServer.getLoginParams
 */
@JvmOverloads
fun KeyServer.getLoginParamsSingle(login: String? = null,
                                   isRecovery: Boolean = false): Single<LoginParams> {
    return Single.defer {
        Single.just(getLoginParams(login, isRecovery))
    }
}

/**
 * @return lazy [Single] with wallet data request result
 *
 * @see KeyServer.getWalletData
 */
fun KeyServer.getWalletDataSingle(walletId: String): Single<WalletData> {
    return Single.defer {
        Single.just(getWalletData(walletId))
    }
}


/**
 * @return lazy [Completable] for wallet save request
 *
 * @see KeyServer.saveWallet
 */
fun KeyServer.saveWalletCompletable(walletData: WalletData): Completable {
    return Completable.defer {
        saveWallet(walletData)
        Completable.complete()
    }
}


/**
 * @return lazy [Completable] for wallet update request
 *
 * @see KeyServer.updateWallet
 */
fun KeyServer.updateWalletCompletable(walletId: String, walletData: WalletData): Completable {
    return Completable.defer {
        updateWallet(walletId, walletData)
        Completable.complete()
    }
}

/**
 * @return lazy [Single] with wallet creation and saving result
 *
 * @see KeyServer.createAndSaveWallet
 */
@JvmOverloads
fun KeyServer.createAndSaveWalletSingle(email: String,
                                        password: CharArray,
                                        rootAccount: Account = Account.random(),
                                        recoveryAccount: Account = Account.random()
): Single<WalletCreateResult> {
    return Single.defer {
        Single.just(createAndSaveWallet(email, password, rootAccount, recoveryAccount))
    }
}

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
        signers: Collection<org.tokend.sdk.api.accounts.model.Account.Signer>,
        newAccount: Account): Single<Transaction> {
    return Single.defer {
        Single.just(createSignersUpdateTransaction(networkParams, originalAccountId, currentAccount,
                signers, newAccount))
    }
}

/**
 * @see KeyServer.createSignersUpdateTransaction
 */
fun createSignersUpdateTransactionSingle(
        networkParams: NetworkParams,
        originalAccountId: String,
        currentAccount: Account,
        signers: Collection<org.tokend.sdk.api.accounts.model.Account.Signer>,
        newAccount: Account): Single<Transaction> {
    return KeyServer.createSignersUpdateTransactionSingle(networkParams, originalAccountId, currentAccount,
            signers, newAccount)
}