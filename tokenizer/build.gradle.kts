import org.tensorflow.lite.schema.ArgMaxOptions

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.mozilla.rust-android-gradle.rust-android") version "0.9.3" apply true
}

android {
    namespace = "org.unitmesh.tokenizer"
    compileSdk = 34
    ndkVersion = "26.1.10909125"

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        externalNativeBuild {
            cmake {
                arguments("-DANDROID_STL=c++_shared")
            }
        }

    }

    externalNativeBuild {
        cmake {
            path = file("../tokenizer/CMakeLists.txt")
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildToolsVersion = "34.0.0"
}

cargo {
    module  = "./rust"
    libname = "djl"
    targets = listOf("arm64", "x86_64", "x86", "arm")
    verbose = true
    prebuiltToolchains = true
    profile = "release"
}

dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("ai.djl:api:0.25.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}