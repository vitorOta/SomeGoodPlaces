plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinAndroidExtensions)
    id(Plugins.kotlinKapt)
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
    implementation(project(":features:places"))

    implementation(Dependencies.hilt)
    kapt(Dependencies.hiltCompiler)

    testImplementation(TestDependencies.jUnit)
    androidTestImplementation(TestDependencies.androidx_test_ext_junit)
    androidTestImplementation(TestDependencies.espresso)
}