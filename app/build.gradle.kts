
plugins {
    id("weather.android.application")
    id("weather.android.data")
}

android {
    namespace = "co.test.weathermap"
    compileSdk = 34

    defaultConfig {
        applicationId = "co.test.weathermap.app"
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(projects.feature.main)
}