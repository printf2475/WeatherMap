import co.test.convention.setNamespace

plugins {
    id("weather.android.library")
    id("weather.android.compose")
}

android {
    setNamespace("core.designsysyem")
}

dependencies {
    implementation(libs.androidx.appcompat)
}