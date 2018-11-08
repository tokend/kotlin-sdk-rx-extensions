# TokenD SDK Rx extensions

This library provides RxJava extensions for [TokenD SDK](https://github.com/tokend/kotlin-sdk).

## Installation

For **Gradle** add following lines to your project's `build.gradle`:
```groovy
allprojects {
    repositories {
        ...
        maven { url "https://maven.tokend.org" }
    }
}

dependencies {
    ...
    compile "org.tokend:rx-sdk:1.0"
}

```

## Usage examples

### API requests

`ApiRequest` can be converted to a lazy `Single` or `Completable`.
Source request will be executed on subscription
and can be canceled by disposing of it.

Kotlin:
```kotlin
api
    .general
    .getSystemInfo()
    .toSingle()
    .subscribe(
            { systemInfo ->
                System.out.println(systemInfo.passphrase)
            },
            { error ->
                error.printStackTrace()
            }
    )
```

Java:
```java
ApiRequest<SystemInfo> request = api.getGeneral().getSystemInfo();
RxApiRequest.toSingle(request)
        .subscribe(new BiConsumer<SystemInfo, Throwable>() {
            @Override
            public void accept(SystemInfo systemInfo, Throwable throwable) throws Exception {
                if (throwable != null) {
                    throwable.printStackTrace();
                } else {
                    System.out.println(systemInfo.getPassphrase());
                }
            }
        });
```

### KeyStorage requests

You can use corresponding Kotlin extensions for `KeyStorage` methods
or wrap methods calls with `RxKeyStorage` in Java.

Kotlin:

```kotlin
val keyStorage = KeyStorage(api.wallets)

keyStorage
        .getLoginParamsSingle()
        .subscribe(
                { loginParams ->
                    System.out.println(loginParams.id)
                },
                { error ->
                    error.printStackTrace()
                }
        )
```

Java:

```java
KeyStorage keyStorage = new KeyStorage(api.getWallets());
RxKeyStorage
        .getLoginParamsSingle(keyStorage)
        .subscribe(new BiConsumer<LoginParams, Throwable>() {
            @Override
            public void accept(LoginParams loginParams, Throwable throwable) throws Exception {
                if (throwable != null) {
                    throwable.printStackTrace();
                } else {
                    System.out.println(loginParams.getId());
                }
            }
        });
```

### Account
You can use corresponding Kotlin extensions for `Account` methods
or wrap methods calls with `RxAccount` in Java.

Kotlin:

```kotlin
val seed = "SCJMKEDU62OECGGNF2D4C5IBOPV66ZYLVMLPLWCJMH2NXQ4FM27H35UN"
        .toCharArray()

Account
        .fromSecretSeedSingle(seed)
        .subscribe(
                { account ->
                    System.out.println(account.accountId)
                },
                { error ->
                    error.printStackTrace()
                }
        )
```

Java:

```java
char[] seed = "SCJMKEDU62OECGGNF2D4C5IBOPV66ZYLVMLPLWCJMH2NXQ4FM27H35UN"
        .toCharArray();

RxAccount
        .fromSecretSeedSingle(seed)
        .subscribe(new BiConsumer<Account, Throwable>() {
            @Override
            public void accept(Account account, Throwable throwable) throws Exception {
                if (throwable != null) {
                    throwable.printStackTrace();
                } else {
                    System.out.println(account.getAccountId());
                }
            }
        });
```