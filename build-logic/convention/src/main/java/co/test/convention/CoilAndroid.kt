package co.test.convention

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureCoilAndroid() {
    val libs = extensions.libs
    dependencies {
        "implementation"(libs.findLibrary("coil.compose").get())
    }
}