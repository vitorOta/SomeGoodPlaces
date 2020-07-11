plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinAndroidExtensions)
}

android {
    defaultConfig {
        applicationId = "com.vitorota.somegoodplaces"
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation(Dependencies.coreKotlinExtensions)
    implementation(Dependencies.appCompat)

    testImplementation(TestDependencies.jUnit)
    androidTestImplementation(TestDependencies.androidx_test_ext_junit)
    androidTestImplementation(TestDependencies.espresso)
}