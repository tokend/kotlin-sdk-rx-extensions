@file:JvmName("RxWalletEncryption")

package org.tokend.rx.extensions

import io.reactivex.Single
import org.tokend.sdk.keyserver.WalletEncryption
import org.tokend.sdk.keyserver.models.KeychainData
import org.tokend.wallet.Account

/**
 * @see WalletEncryption.encryptSecretSeed
 */
@JvmName("_encryptSecretSeedSingle")
fun WalletEncryption.encryptSecretSeedSingle(
    seed: CharArray,
    iv: ByteArray,
    walletEncryptionKey: ByteArray
): Single<KeychainData> {
    return Single.defer {
        Single.just(encryptSecretSeed(seed, iv, walletEncryptionKey))
    }
}

/**
 * @see WalletEncryption.encryptSecretSeed
 */
fun encryptSecretSeedSingle(
    seed: CharArray,
    iv: ByteArray,
    walletEncryptionKey: ByteArray
): Single<KeychainData> {
    return WalletEncryption.encryptSecretSeedSingle(seed, iv, walletEncryptionKey)
}

/**
 * @see WalletEncryption.decryptSecretSeed
 */
@JvmName("_decryptSecretSeedSingle")
fun WalletEncryption.decryptSecretSeedSingle(
    keychainData: KeychainData,
    walletEncryptionKey: ByteArray
): Single<CharArray> {
    return Single.defer {
        Single.just(decryptSecretSeed(keychainData, walletEncryptionKey))
    }
}

/**
 * @see WalletEncryption.decryptSecretSeed
 */
fun decryptSecretSeedSingle(
    keychainData: KeychainData,
    walletEncryptionKey: ByteArray
): Single<CharArray> {
    return WalletEncryption.decryptSecretSeedSingle(keychainData, walletEncryptionKey)
}

/**
 * @see WalletEncryption.encryptAccounts
 */
@JvmName("_encryptAccountSingle")
fun WalletEncryption.encryptAccountsSingle(
    accounts: List<Account>,
    walletEncryptionKey: ByteArray,
): Single<KeychainData> {
    return Single.defer {
        Single.just(encryptAccounts(accounts, walletEncryptionKey))
    }
}

/**
 * @see WalletEncryption.encryptAccounts
 */
fun encryptAccountSingle(
    accounts: List<Account>,
    walletEncryptionKey: ByteArray,
): Single<KeychainData> {
    return WalletEncryption.encryptAccountsSingle(accounts, walletEncryptionKey)
}

/**
 * @see WalletEncryption.decryptAccounts
 */
@JvmName("_decryptAccountSingle")
fun WalletEncryption.decryptAccountsSingle(
    keychainData: KeychainData,
    walletEncryptionKey: ByteArray,
): Single<List<Account>> {
    return Single.defer {
        Single.just(decryptAccounts(keychainData, walletEncryptionKey))
    }
}

/**
 * @see WalletEncryption.decryptAccounts
 */
fun decryptAccountsSingle(
    keychainData: KeychainData,
    walletEncryptionKey: ByteArray,
): Single<List<Account>> {
    return WalletEncryption.decryptAccountsSingle(keychainData, walletEncryptionKey)
}