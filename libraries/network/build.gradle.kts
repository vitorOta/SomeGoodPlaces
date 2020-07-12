plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinAndroidExtensions)
}
android {
    defaultConfig {
        buildConfigField("String", "API_URL", "\"https://hotmart-mobile-app.herokuapp.com/\"")
    }
}

dependencies {
    api(Dependencies.gson)
    api(Dependencies.retrofit)
    implementation(Dependencies.retrofitGsonConverter)
    implementation(Dependencies.okHttpLoggingInterceptor)
}