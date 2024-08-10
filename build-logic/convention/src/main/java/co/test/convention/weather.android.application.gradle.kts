import co.test.convention.configureHiltAndroid
import co.test.convention.configureKotlinAndroid
import co.test.convention.libs
import gradle.kotlin.dsl.accessors._4b055a01bae563bd2c86a468691a3401.implementation

plugins {
    id("com.android.application")
}

configureKotlinAndroid()
configureHiltAndroid()

dependencies {
    val libs = project.extensions.libs
    implementation(libs.findLibrary("junit4").get())
    androidTestImplementation(libs.findLibrary("androidx.test.ext").get())
}