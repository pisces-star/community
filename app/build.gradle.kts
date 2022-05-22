plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.didi.drouter")
    kotlin("plugin.serialization") version "1.6.21"
    kotlin("kapt")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.oppo.community"
        minSdk = 26
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

drouter {
    debug = true
}

dependencies {

    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.timber)
    implementation(libs.coil)
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)
    implementation(libs.retrofit)
    implementation(libs.lifecycle.runtime)
    implementation(libs.koin)
    implementation(libs.androidx.legacy)
    implementation(libs.drouter)
    implementation(libs.kotlin.serialization)
    implementation(libs.serialization.converter)
    implementation(libs.stetho.okhttp)
    implementation(libs.okhttp.logging)
    implementation(libs.room.ktx)
    implementation(libs.androidx.datastore)
    kapt(libs.room.compiler)
    testImplementation(libs.junit)
    androidTestImplementation(libs.test.ext)
    androidTestImplementation(libs.test.espresso)
}