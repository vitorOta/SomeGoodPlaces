plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinAndroidExtensions)
    id(Plugins.kotlinKapt)
}

android {
    defaultConfig {
        applicationId = "com.vitorota.somegoodplaces"
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation(project(":features:places"))

    implementation(Dependencies.hilt)
    kapt(Dependencies.hiltCompiler)

    testImplementation(TestDependencies.jUnit)
    androidTestImplementation(TestDependencies.androidx_test_ext_junit)
    androidTestImplementation(TestDependencies.espresso)
}