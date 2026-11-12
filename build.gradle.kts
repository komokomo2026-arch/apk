plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}
android {
    namespace = "ke.ekambani.mpesa.reader"
    compileSdk = 35
    defaultConfig {
        applicationId = "ke.ekambani.mpesa.reader"
        minSdk = 26
        targetSdk = 28
        versionCode = 1
        versionName = "0.1.0-sample"
    }
}
