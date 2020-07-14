plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinAndroidExtensions)
}
apply(from = rootProject.file("buildSrc/androidDefaultConfig.gradle"))

android {
    resourcePrefix("")
}

dependencies {
    api(Dependencies.appCompat)
    api(Dependencies.material)
    api(Dependencies.constraintLayout)
    api(Dependencies.recyclerView)
    api(Dependencies.cardView)
    api(Dependencies.glide)
}