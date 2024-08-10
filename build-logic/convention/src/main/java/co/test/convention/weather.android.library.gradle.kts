import co.test.convention.configureDataAndroid
import co.test.convention.configureKotlinAndroid
import co.test.convention.libs

plugins {
    id("com.android.library")
}

configureKotlinAndroid()
configureDataAndroid()

dependencies {
    val libs = project.extensions.libs

    implementation(libs.findLibrary("junit4").get())
    androidTestImplementation(libs.findLibrary("androidx.test.ext").get())
}