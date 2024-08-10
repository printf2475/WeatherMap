pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "WeatherMap"

include(":app")
include(
    ":feature:main",
    ":feature:search",
    ":feature:weather"
)
include(
    ":core:designsystem",
    ":core:navigation"
)
include(":core:data")
include(":core:domain")
include(":core:model")
