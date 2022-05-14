plugins {
    id ("com.android.application")
    id ("kotlin-android")
}

android {
    compileSdk =  32

    defaultConfig {
        applicationId =  "com.pisces.business"
        minSdk  = 26
        targetSdk =  32
        versionCode =  1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled =  false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility  = JavaVersion.VERSION_1_8
        targetCompatibility  = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose =  true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0-alpha08"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation (libs.androidx.core)
    implementation (libs.androidx.appcompat)
    implementation (libs.material)
    implementation (libs.compose.ui)
    implementation (libs.compose.material)
    implementation (libs.compose.preview)
    implementation (libs.lifecycle.viewmodel)
    implementation (libs.activity.compose)
    implementation(libs.timber)
    implementation(libs.coil)
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)
    implementation(libs.retrofit)
    implementation(libs.lifecycle.runtime)
    implementation(libs.koin)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    testImplementation (libs.junit)
    androidTestImplementation (libs.test.ext)
    androidTestImplementation (libs.test.espresso)
    androidTestImplementation (libs.compose.test)
    debugImplementation (libs.compose.tool)
}