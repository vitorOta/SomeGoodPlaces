object Plugins {
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
}

object PluginDeps {
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
}

object Dependencies {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val coreKotlinExtensions = "androidx.core:core-ktx:${Versions.coreKotlinExtensions}"

    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
}

object TestDependencies {
    const val jUnit = "junit:junit:${TestVersions.jUnit}"
    const val androidx_test_ext_junit =
        "androidx.test.ext:junit:${TestVersions.androidx_test_ext_junit}"

    const val espresso = "androidx.test.espresso:espresso-core:${TestVersions.espresso}"
}