plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinAndroidExtensions)
}

dependencies {
    api(Dependencies.appCompat)
    api(Dependencies.constraintLayout)
}