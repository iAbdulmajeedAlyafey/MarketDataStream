package com.market.stream

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    // TODO Configure Compose-specific options..
    commonExtension.apply {
        buildFeatures {
            compose = true
        }

        dependencies {

        }

        testOptions {
            unitTests {
                isIncludeAndroidResources = true
            }
        }
    }
}
