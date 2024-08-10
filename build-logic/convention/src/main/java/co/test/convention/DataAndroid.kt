package co.test.convention

import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import org.gradle.api.Project
import org.gradle.internal.impldep.com.esotericsoftware.minlog.Log

enum class LocalProperty {
    WEATHER_API_KEY,
    WEATHER_API_BASE_URL
}
internal fun Project.configureDataAndroid() {
    androidExtension.apply {
        buildFeatures {
            buildConfig = true
        }

        defaultConfig {
            val key = getApiKey("GOOGLE_MAP_API_KEY")
            print("GOOGLE_MAP_API_KEY: $key")
            manifestPlaceholders["GOOGLE_MAP_API_KEY"] = key
            for (item in LocalProperty.values()) {
                buildConfigField("String", item.name, getApiKey(item.name))
            }
        }
    }
}

fun Project.getApiKey(propertyKey: String): String {
    return gradleLocalProperties(rootDir, providers).getProperty(propertyKey)
}