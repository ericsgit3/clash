@file:Suppress("UNUSED_VARIABLE")

import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension
import java.net.URL
import java.util.*


    repositories {
    }
    dependencies {
        classpath(libs.build.android)
        classpath(libs.build.kotlin.common)
        classpath(libs.build.kotlin.serialization)
        classpath(libs.build.ksp)
        classpath(libs.build.golang)
    }
}

subprojects {
    repositories {
        mavenCentral()
        
    }

    val isApp = name == "app"

    apply(plugin = if (isApp) "com.android.application" else "com.android.library")

    extensions.configure<BaseExtension> {
        defaultConfig {
            if (isApp) {
                
            }

            minSdk = 22
            targetSdk = 33

            versionName = "1.0.0"
            versionCode = 100

            resValue("string", "release_name", "v$versionName")
            resValue("integer", "release_code", "$versionCode")

            externalNativeBuild {
                cmake {
                    abiFilters("arm64-v8a", "armeabi-v7a", "x86", "x86_64")
                }
            }

            if (!isApp) {
                consumerProguardFiles("consumer-rules.pro")
            } else {
                setProperty("archivesBaseName", "cfa-$versionName")
            }
        }

        ndkVersion = "23.0.7599858"

        compileSdkVersion(defaultConfig.targetSdk!!)

        if (isApp) {
            packagingOptions {
                resources {
                    excludes.add("DebugProbesKt.bin")
                }
            }
        }

        productFlavors {
            flavorDimensions("feature")

            create("foss") {
                isDefault = true
                dimension = flavorDimensionList[0]
                versionNameSuffix = ".foss"

                buildConfigField("boolean", "PREMIUM", "Boolean.parseBoolean(\"false\")")

                if (isApp) {
                    applicationIdSuffix = ".foss"
                }
            }
            create("premium") {
                dimension = flavorDimensionList[0]
                versionNameSuffix = ".premium"

                buildConfigField("boolean", "PREMIUM", "Boolean.parseBoolean(\"true\")")
            }
        }

        signingConfigs {
            val keystore = rootProject.file("signing.properties")
            if (keystore.exists()) {
                create("release") {
                    val prop = Properties().apply {
                        keystore.inputStream().use(this::load)
                    }

                    storeFile = rootProject.file(prop.getProperty("keystore.path")!!)
                    storePassword = prop.getProperty("keystore.password")!!
                    keyAlias = prop.getProperty("key.alias")!!
                    keyPassword = prop.getProperty("key.password")!!
                }
            }
        }

      
