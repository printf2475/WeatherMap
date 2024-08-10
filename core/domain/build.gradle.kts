import co.test.convention.setNamespace

plugins {
    id("weather.android.library")
    id("weather.android.hilt")
}


android {
    setNamespace("domain")
}
dependencies{
    implementation(projects.core.model)
    implementation(libs.kotlinx.coroutines.android)
}
