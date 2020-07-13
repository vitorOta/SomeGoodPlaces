plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinAndroidExtensions)
}

dependencies {
    implementation(project(":libraries:common"))
    implementation(project(":libraries:ui_components"))
    implementation(project(":libraries:network"))

    testImplementation(project(":libraries:testing"))
}