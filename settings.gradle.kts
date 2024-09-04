pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    // NOTE: Do not place your application dependencies here; they belong
    // in the individual module build.gradle.kts files
    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "com.android.tools.build") {
                useModule("com.android.tools.build:gradle:7.3.1")
            }
            if (requested.id.namespace == "org.jetbrains.kotlin") {
                val kotlin_version = "1.8.10"
                useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
            }
            if (requested.id.namespace == "com.google.firebase") {
                useModule("com.google.firebase:firebase-crashlytics-gradle:2.9.2")
            }
        }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
        maven {
            setUrl("https://jitpack.io")
        }
        flatDir {
            dirs("libs")
        }
    }
}

include(":app")
//include ':dcache-android'
rootProject.name = "DoraCacheSample"

