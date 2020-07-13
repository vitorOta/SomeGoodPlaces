plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinAndroidExtensions)
    id(Plugins.kotlinKapt)
}

dependencies {
    implementation(project(":libraries:common"))
    implementation(project(":libraries:ui_components"))
    implementation(project(":libraries:network"))
    implementation(Dependencies.hilt)
    kapt(Dependencies.hiltCompiler)

    testImplementation(project(":libraries:testing"))
}