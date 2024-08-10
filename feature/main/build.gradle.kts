import co.test.convention.setNamespace

plugins {
    id("weather.android.feature")
}

android {
    setNamespace("feature.main")
}

dependencies {
    api(projects.core.navigation)
    implementation(projects.feature.search)
    implementation(projects.feature.weather)
}