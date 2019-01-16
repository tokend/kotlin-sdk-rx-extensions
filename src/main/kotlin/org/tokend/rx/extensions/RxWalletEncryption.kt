@file:JvmName("RxWalletEncryption")

package org.tokend.rx.extensions

import io.reactivex.Single
import org.tokend.sdk.keyserver.WalletEncryption
import org.tokend.sdk.keyserver.models.EncryptedWalletAccount
import org.tokend.sdk.keyserver.models.KeychainData
import org.tokend.wallet.Account

/**
 * @see WalletEncryption.encryptSecretSeed
 */
@JvmName("_encryptSecretSeedSingle")
fun WalletEncryption.encryptSecretSeedSingle(seed: CharArray,
                                             iv: ByteArray,
                                             walletEncryptionKey: ByteArray): Single<KeychainData> {
    return Single.defer {
        Single.just(encryptSecretSeed(seed, iv, walletEncryptionKey))
    }
}

/**
 * @see WalletEncryption.encryptSecretSeed
 */
fun encryptSecretSeedSingle(seed: CharArray,
                            iv: ByteArray,
                            walletEncryptionKey: ByteArray): Single<KeychainData> {
    return WalletEncryption.encryptSecretSeedSingle(seed, iv, walletEncryptionKey)
}

/**
 * @see WalletEncryption.decryptSecretSeed
 */
@JvmName("_decryptSecretSeedSingle")
fun WalletEncryption.decryptSecretSeedSingle(keychainData: KeychainData,
                                             walletEncryptionKey: ByteArray): Single<CharArray> {
    return Single.defer {
        Single.just(decryptSecretSeed(keychainData, walletEncryptionKey))
    }
}

/**
 * @see WalletEncryption.decryptSecretSeed
 */
fun decryptSecretSeedSingle(keychainData: KeychainData,
                            walletEncryptionKey: ByteArray): Single<CharArray> {
    return WalletEncryption.decryptSecretSeedSingle(keychainData, walletEncryptionKey)
}

/**
 * @see WalletEncryption.encryptAccount
 */
@JvmName("_encryptAccountSingle")
fun WalletEncryption.encryptAccountSingle(email: String,
                                          seed: CharArray,
                                          accountId: String,
                                          walletEncryptionKey: ByteArray,
                                          keyDerivationSalt: ByteArray): Single<EncryptedWalletAccount> {
    return Single.defer {
        Single.just(encryptAccount(email, seed, accountId, walletEncryptionKey, keyDerivationSalt))
    }
}

/**
 * @see WalletEncryption.encryptAccount
 */
fun encryptAccountSingle(email: String,
                         seed: CharArray,
                         accountId: String,
                         walletEncryptionKey: ByteArray,
                         keyDerivationSalt: ByteArray): Single<EncryptedWalletAccount> {
    return WalletEncryption.encryptAccountSingle(email, seed, accountId, walletEncryptionKey, keyDerivationSalt)
}

/**
 * @see WalletEncryption.encryptAccount
 */
@JvmName("_encryptAccountSingle")
fun WalletEncryption.encryptAccountSingle(email: String,
                                          account: Account,
                                          walletEncryptionKey: ByteArray,
                                          keyDerivationSalt: ByteArray): Single<EncryptedWalletAccount> {
    return Single.defer {
        Single.just(encryptAccount(email, account, walletEncryptionKey, keyDerivationSalt))
    }
}

/**
 * @see WalletEncryption.encryptAccount
 */
fun encryptAccountSingle(email: String,
                         account: Account,
                         walletEncryptionKey: ByteArray,
                         keyDerivationSalt: ByteArray): Single<EncryptedWalletAccount> {
    return WalletEncryption.encryptAccountSingle(email, account, walletEncryptionKey, keyDerivationSalt)
}