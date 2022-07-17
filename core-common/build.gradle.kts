plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

dependencies {

    implementation(libs.androidx.core)
    implementation(libs.io.coil.kt.coil)
    implementation(libs.androidx.datastore)
    implementation(libs.androidx.appcompat)
    implementation(libs.com.facebook.stetho)
    implementation(libs.com.jakewharton.timber)
    implementation(libs.com.squareup.retrofit2)
    implementation(libs.com.github.viewbinding.ktx)
    implementation(libs.com.github.viewbinding.base)
    implementation(libs.jp.wasabeef.transformers.coil)
    implementation(libs.androidx.activity.activity.ktx)
    implementation(libs.com.jakewharton.serialization.converter)
    implementation(libs.com.squareup.okhttp3.logging.interceptor)
    implementation(libs.androidx.lifecycle.lifecycle.viewmodel.ktx)
    implementation(libs.org.jetbrains.kotlinx.kotlinx.serialization)
    implementation(libs.org.jetbrains.kotlinx.kotlinx.coroutines.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.espresso.espresso.core)
}