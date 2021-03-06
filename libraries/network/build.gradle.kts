plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
}
apply(from = rootProject.file("buildSrc/androidDefaultConfig.gradle"))

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