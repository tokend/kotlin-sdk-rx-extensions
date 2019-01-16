@file:JvmName("RxWalletKeyDerivation")

package org.tokend.rx.extensions

import io.reactivex.Single
import org.tokend.sdk.keyserver.WalletKeyDerivation
import org.tokend.sdk.keyserver.models.KdfAttributes

/**
 * @see WalletKeyDerivation.deriveWalletEncryptionKey
 */
@JvmName("_deriveWalletEncryptionKeySingle")
fun WalletKeyDerivation.deriveWalletEncryptionKeySingle(login: String,
                                                        password: CharArray,
                                                        kdfAttributes: KdfAttributes): Single<ByteArray> {
    return Single.defer {
        Single.just(deriveWalletEncryptionKey(login, password, kdfAttributes))
    }
}

/**
 * @see WalletKeyDerivation.deriveWalletEncryptionKey
 */
fun deriveWalletEncryptionKeySingle(login: String,
                                    password: CharArray,
                                    kdfAttributes: KdfAttributes): Single<ByteArray> {
    return WalletKeyDerivation.deriveWalletEncryptionKeySingle(login, password, kdfAttributes)
}

/**
 * @see WalletKeyDerivation.deriveWalletId
 */
@JvmName("_deriveWalletIdSingle")
fun WalletKeyDerivation.deriveWalletIdSingle(login: String,
                                             password: CharArray,
                                             kdfAttributes: KdfAttributes): Single<ByteArray> {
    return Single.defer {
        Single.just(deriveWalletId(login, password, kdfAttributes))
    }
}

/**
 * @see WalletKeyDerivation.deriveWalletId
 */
fun deriveWalletIdSingle(login: String,
                         password: CharArray,
                         kdfAttributes: KdfAttributes): Single<ByteArray> {
    return WalletKeyDerivation.deriveWalletIdSingle(login, password, kdfAttributes)
}

/**
 * @see WalletKeyDerivation.deriveAndEncodeWalletId
 */
@JvmName("_deriveAndEncodeWalletIdSingle")
fun WalletKeyDerivation.deriveAndEncodeWalletIdSingle(login: String,
                                                      password: CharArray,
                                                      kdfAttributes: KdfAttributes): Single<String> {
    return Single.defer {
        Single.just(deriveAndEncodeWalletId(login, password, kdfAttributes))
    }
}

/**
 * @see WalletKeyDerivation.deriveAndEncodeWalletId
 */
fun deriveAndEncodeWalletIdSingle(login: String,
                                  password: CharArray,
                                  kdfAttributes: KdfAttributes): Single<String> {
    return WalletKeyDerivation.deriveAndEncodeWalletIdSingle(login, password, kdfAttributes)
}

/**
 * @see WalletKeyDerivation.deriveKey
 */
@JvmName("_deriveKeySingle")
fun WalletKeyDerivation.deriveKeySingle(login: ByteArray,
                                        password: ByteArray,
                                        masterKey: ByteArray,
                                        kdfAttributes: KdfAttributes): Single<ByteArray> {
    return Single.defer {
        Single.just(deriveKey(login, password, masterKey, kdfAttributes))
    }
}

/**
 * @see WalletKeyDerivation.deriveKey
 */
fun deriveKeySingle(login: ByteArray,
                    password: ByteArray,
                    masterKey: ByteArray,
                    kdfAttributes: KdfAttributes): Single<ByteArray> {
    return WalletKeyDerivation.deriveKeySingle(login, password, masterKey, kdfAttributes)
}