pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "GiphyApp"
include(
    ":app",
    ":core",
    ":data",
    ":domain",
    ":gif",
    ":network",
    ":resources"
)
