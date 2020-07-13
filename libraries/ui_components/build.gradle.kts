plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinAndroidExtensions)
}
android {
    resourcePrefix("")
}

dependencies {
    api(Dependencies.appCompat)
    api(Dependencies.constraintLayout)
    api(Dependencies.glide)
}