import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "com.market.stream.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
}

gradlePlugin {
    // TODO Configure other plugins..
    plugins {
        register("androidApplication") {
            id = libs.plugins.marketdata.android.application.get().pluginId
            implementationClass = "ApplicationConventionPlugin"
        }
        register("androidCompose") {
            id = libs.plugins.marketdata.android.compose.get().pluginId
            implementationClass = "ComposeConventionPlugin"
        }
    }
}
