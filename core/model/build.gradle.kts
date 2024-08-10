import co.test.convention.setNamespace

plugins {
    id("weather.android.library")
    id("kotlin-parcelize")
    alias(libs.plugins.jetbrains.kotlin.serialization)
}


android {
    setNamespace("core.model")
}

dependencies{
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.navigation.common.ktx)
}
