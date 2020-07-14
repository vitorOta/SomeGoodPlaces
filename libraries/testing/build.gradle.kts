plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
}
apply(from = rootProject.file("buildSrc/androidDefaultConfig.gradle"))

dependencies {
    api(TestDependencies.jUnit)
    api(TestDependencies.androidx_test_ext_junit)
    api(TestDependencies.mockk)
    api(TestDependencies.mockWebServer)
    api(TestDependencies.coroutinesTest)
    api(TestDependencies.androidCoreTesting)
}