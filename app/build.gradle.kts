plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinAndroidExtensions)
    id(Plugins.kotlinKapt)
    id(Plugins.hiltAndroid)
}
apply(from = rootProject.file("buildSrc/androidDefaultConfig.gradle"))

android {
    defaultConfig {
        applicationId = "com.vitorota.somegoodplaces"
        versionCode = 1
        versionName = "1.0"
    }

    resourcePrefix("")
}

dependencies {
    implementation(project(":libraries:ui_components"))
    implementation(project(":features:places"))

    implementation(Dependencies.navigation)
    implementation(Dependencies.navigationUi)

    implementation(Dependencies.hilt)
    implementation(Dependencies.hiltViewModel)
    kapt(Dependencies.hiltCompiler)
    kapt(Dependencies.hiltExtensionCompiler)

    testImplementation(TestDependencies.jUnit)
    androidTestImplementation(TestDependencies.androidx_test_ext_junit)
    androidTestImplementation(TestDependencies.espresso)
}