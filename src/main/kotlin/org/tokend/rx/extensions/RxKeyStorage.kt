@file:JvmName("RxKeyStorage")

package org.tokend.rx.extensions

import io.reactivex.Completable
import io.reactivex.Single
import org.tokend.sdk.keyserver.KeyStorage
import org.tokend.sdk.keyserver.models.*
import org.tokend.wallet.Account
import org.tokend.wallet.NetworkParams
import org.tokend.wallet.Transaction

/**
 * @return lazy [Single] with wallet info request result
 *
 * @see KeyStorage.getWalletInfo
 */
@JvmOverloads
fun KeyStorage.getWalletInfoSingle(login: String, password: CharArray,
                                   isRecovery: Boolean = false): Single<WalletInfo> {
    return Single.defer {
        Single.just(getWalletInfo(login, password, isRecovery))
    }
}

/**
 * @return lazy [Single] with login params request result
 *
 * @see KeyStorage.getLoginParams
 */
@JvmOverloads
fun KeyStorage.getLoginParamsSingle(login: String? = null,
                                    isRecovery: Boolean = false): Single<LoginParams> {
    return Single.defer {
        Single.just(getLoginParams(login, isRecovery))
    }
}

/**
 * @return lazy [Single] with wallet data request result
 *
 * @see KeyStorage.getWalletData
 */
fun KeyStorage.getWalletDataSingle(walletId: String): Single<WalletData> {
    return Single.defer {
        Single.just(getWalletData(walletId))
    }
}

/**
 * @return lazy [Completable] for wallet save request
 *
 * @see KeyStorage.saveWallet
 */
fun KeyStorage.saveWalletCompletable(walletData: WalletData): Completable {
    return Completable.defer {
        saveWallet(walletData)
        Completable.complete()
    }
}

/**
 * @return lazy [Completable] for wallet update request
 *
 * @see KeyStorage.updateWallet
 */
fun KeyStorage.updateWalletCompletable(walletId: String, walletData: WalletData): Completable {
    return Completable.defer {
        updateWallet(walletId, walletData)
        Completable.complete()
    }
}

/**
 * @return lazy [Single] with wallet creation and saving result
 *
 * @see KeyStorage.createAndSaveWallet
 */
@JvmOverloads
fun KeyStorage.createAndSaveWalletSingle(
        email: String,
        password: CharArray,
        rootAccount: Account = Account.random(),
        recoveryAccount: Account = Account.random()
): Single<WalletCreateResult> {
    return Single.defer {
        Single.just(createAndSaveWallet(email, password, rootAccount, recoveryAccount))
    }
}

/**
 * @see KeyStorage.getWalletKey
 */
fun KeyStorage.Companion.getWalletKeySingle(login: String, password: CharArray,
                                            kdfAttributes: KdfAttributes): Single<ByteArray> {
    return Single.defer {
        Single.just(KeyStorage.getWalletKey(login, password, kdfAttributes))
    }
}

/**
 * @see KeyStorage.getWalletKey
 */
fun getWalletKeySingle(login: String, password: CharArray,
                       kdfAttributes: KdfAttributes): Single<ByteArray> {
    return KeyStorage.getWalletKeySingle(login, password, kdfAttributes)
}

/**
 * @see KeyStorage.decryptSecretSeed
 */
fun KeyStorage.Companion.decryptSecretSeedSingle(iv: ByteArray, cipherText: ByteArray,
                                                 key: ByteArray): Single<CharArray> {
    return Single.defer {
        Single.just(KeyStorage.decryptSecretSeed(iv, cipherText, key))
    }
}

/**
 * @see KeyStorage.decryptSecretSeed
 */
fun decryptSecretSeedSingle(iv: ByteArray, cipherText: ByteArray,
                            key: ByteArray): Single<CharArray> {
    return KeyStorage.decryptSecretSeedSingle(iv, cipherText, key)
}

/**
 * @see KeyStorage.getWalletIdHex
 */
fun KeyStorage.Companion.getWalletIdHexSingle(login: String, password: CharArray,
                                              kdfAttributes: KdfAttributes): Single<String> {
    return Single.defer {
        Single.just(KeyStorage.getWalletIdHex(login, password, kdfAttributes))
    }
}

/**
 * @see KeyStorage.getWalletIdHex
 */
fun getWalletIdHexSingle(login: String, password: CharArray,
                         kdfAttributes: KdfAttributes): Single<String> {
    return KeyStorage.getWalletIdHexSingle(login, password, kdfAttributes)
}

/**
 * @see KeyStorage.encryptWalletAccount
 */
fun KeyStorage.Companion.encryptWalletAccountSingle(email: String,
                                                    seed: CharArray,
                                                    accountId: String,
                                                    encryptionKey: ByteArray,
                                                    keyDerivationSalt: ByteArray): Single<EncryptedKey> {
    return Single.defer {
        Single.just(KeyStorage.encryptWalletAccount(email, seed, accountId, encryptionKey, keyDerivationSalt))
    }
}

/**
 * @see KeyStorage.encryptWalletAccount
 */
fun encryptWalletAccountSingle(email: String,
                               seed: CharArray,
                               accountId: String,
                               encryptionKey: ByteArray,
                               keyDerivationSalt: ByteArray): Single<EncryptedKey> {
    return KeyStorage.encryptWalletAccountSingle(email, seed, accountId, encryptionKey, keyDerivationSalt)
}

/**
 * @see KeyStorage.createWallet
 */
@JvmOverloads
fun KeyStorage.Companion.createWalletSingle(
        email: String,
        password: CharArray,
        kdfAttributes: KdfAttributes,
        kdfVersion: Long,
        rootAccount: Account = Account.random(),
        recoveryAccount: Account = Account.random()
): Single<WalletCreateResult> {
    return Single.defer {
        Single.just(KeyStorage.createWallet(email, password, kdfAttributes, kdfVersion, rootAccount, recoveryAccount))
    }
}

/**
 * @see KeyStorage.createWallet
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
    return KeyStorage.createWalletSingle(email, password, kdfAttributes, kdfVersion, rootAccount, recoveryAccount)
}

/**
 * @see KeyStorage.createWallet
 */
@JvmOverloads
fun KeyStorage.Companion.createWalletSingle(
        email: String,
        password: CharArray,
        loginParams: LoginParams,
        rootAccount: Account = Account.random(),
        recoveryAccount: Account = Account.random()
): Single<WalletCreateResult> {
    return Single.defer {
        Single.just(KeyStorage.createWallet(email, password, loginParams, rootAccount, recoveryAccount))
    }
}

/**
 * @see KeyStorage.createWallet
 */
@JvmOverloads
fun createWalletSingle(
        email: String,
        password: CharArray,
        loginParams: LoginParams,
        rootAccount: Account = Account.random(),
        recoveryAccount: Account = Account.random()
): Single<WalletCreateResult> {
    return KeyStorage.createWalletSingle(email, password, loginParams, rootAccount, recoveryAccount)
}

/**
 * @see KeyStorage.createSignersUpdateTransaction
 */
fun KeyStorage.Companion.createSignersUpdateTransactionSingle(networkParams: NetworkParams,
                                                              originalAccountId: String,
                                                              currentAccount: Account,
                                                              signers: Collection<org.tokend.sdk.api.accounts.model.Account.Signer>,
                                                              newAccount: Account): Single<Transaction> {
    return Single.defer {
        Single.just(KeyStorage.createSignersUpdateTransaction(networkParams, originalAccountId,
                currentAccount, signers, newAccount))
    }
}

/**
 * @see KeyStorage.createSignersUpdateTransaction
 */
fun createSignersUpdateTransactionSingle(networkParams: NetworkParams,
                                         originalAccountId: String,
                                         currentAccount: Account,
                                         signers: Collection<org.tokend.sdk.api.accounts.model.Account.Signer>,
                                         newAccount: Account): Single<Transaction> {
    return KeyStorage.createSignersUpdateTransactionSingle(networkParams, originalAccountId,
            currentAccount, signers, newAccount)
}
