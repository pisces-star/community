plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.didi.drouter")
    kotlin("plugin.serialization")
    kotlin("kapt")
}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.oppo.community"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
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
    buildFeatures {
        viewBinding = true
    }
}

drouter {
    debug = true
}

dependencies {
    implementation(project(":core-common"))
    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.com.jakewharton.timber)
    implementation(libs.io.coil.kt.coil)
    implementation(libs.io.insert.koin.koin.android)
    implementation(libs.io.github.didi.drouter.api)
    implementation(libs.androidx.lifecycle.lifecycle.viewmodel.ktx)
    implementation(libs.org.jetbrains.kotlinx.kotlinx.serialization)
    implementation(libs.com.jakewharton.serialization.converter)
    implementation(libs.com.facebook.stetho)
    implementation(libs.com.squareup.retrofit2)
    implementation(libs.com.squareup.okhttp3.logging.interceptor)
    implementation(libs.com.google.android.material)
    implementation(libs.jp.wasabeef.transformers.coil)
    implementation(libs.androidx.datastore)
    implementation(libs.androidx.activity.activity.ktx)
    implementation(libs.org.jetbrains.kotlinx.kotlinx.coroutines.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.espresso.espresso.core)
}