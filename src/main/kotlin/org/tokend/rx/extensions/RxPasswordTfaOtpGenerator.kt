@file:JvmName("RxPasswordTfaOtpGenerator")

package org.tokend.rx.extensions

import io.reactivex.Single
import org.tokend.sdk.tfa.NeedTfaException
import org.tokend.sdk.tfa.PasswordTfaOtpGenerator

/**
 * @return lazy [Single] with generated OTP result.
 */
fun PasswordTfaOtpGenerator.generateSingle(tfaException: NeedTfaException, email: String, password: CharArray): Single<String> {
    return Single.defer {
        Single.just(generate(tfaException, email, password))
    }
}