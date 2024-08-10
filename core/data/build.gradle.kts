import co.test.convention.setNamespace

plugins {
    id("weather.android.library")
    id("weather.android.hilt")
    id("weather.android.ktor")
    id("kotlin-parcelize")
    alias(libs.plugins.jetbrains.kotlin.serialization)
}


android {
    setNamespace("core.data")
}

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.domain)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.runtime.android)
}