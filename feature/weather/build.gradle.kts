import co.test.convention.setNamespace

plugins {
    id("weather.android.feature")
    alias(libs.plugins.jetbrains.kotlin.serialization)
}

android {
    setNamespace("feature.weather")
}

dependencies {
    implementation(libs.maps.compose)
    implementation(libs.play.services.maps)
    implementation(libs.kotlinx.serialization.json)
}