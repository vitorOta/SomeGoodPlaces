plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinAndroidExtensions)
    id(Plugins.kotlinKapt)
    id(Plugins.hiltAndroid)
}

dependencies {
    implementation(project(":libraries:ui_components"))
    implementation(project(":libraries:network"))
    implementation(Dependencies.hilt)
    kapt(Dependencies.hiltCompiler)

    testImplementation(project(":libraries:testing"))
}