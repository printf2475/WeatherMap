import co.test.convention.setNamespace

plugins {
    id("weather.android.library")
    id("weather.android.compose")
    alias(libs.plugins.jetbrains.kotlin.serialization)
}

android {
    setNamespace("core.navigation")
}

dependencies {
    implementation(projects.core.model)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.navigation.common.ktx)
}