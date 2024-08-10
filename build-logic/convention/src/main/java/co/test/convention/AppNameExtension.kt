package co.test.convention

import org.gradle.api.Project

fun Project.setNamespace(name: String) {
    androidExtension.apply {
        namespace = "co.test.weathermap.$name"
    }
}