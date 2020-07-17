plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinAndroidExtensions)
    id(Plugins.kotlinKapt)
    id(Plugins.navSafeArgs)
    id(Plugins.hiltAndroid)
}
apply(from = rootProject.file("buildSrc/androidDefaultConfig.gradle"))

dependencies {
    implementation(project(":libraries:common"))
    implementation(project(":libraries:ui_components"))
    implementation(project(":libraries:network"))

    implementation(Dependencies.navigation)
    implementation(Dependencies.navigationUi)
    implementation(Dependencies.viewModelKtx)
    implementation(Dependencies.liveDataKtx)
    implementation(Dependencies.fragmentKtx)

    implementation(Dependencies.hilt)
    implementation(Dependencies.hiltViewModel)
    kapt(Dependencies.hiltCompiler)
    kapt(Dependencies.hiltExtensionCompiler)

    testImplementation(project(":libraries:testing"))
    androidTestImplementation(project(":libraries:testing"))
}