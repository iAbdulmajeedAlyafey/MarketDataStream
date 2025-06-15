pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "MarketDataStream"
include(
    ":app",
    ":core:design-system",
    ":core:model",
    ":feature:asset-details:data",
    ":feature:asset-details:domain",
    ":feature:asset-details:ui",
    ":feature:dashboard:data",
    ":feature:dashboard:domain",
    ":feature:dashboard:ui",
)
 