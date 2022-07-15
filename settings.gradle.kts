pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri ("https://www.jitpack.io") }
    }
}
rootProject.name = "community"
include (":app")
enableFeaturePreview("VERSION_CATALOGS")
include(":core-common")
