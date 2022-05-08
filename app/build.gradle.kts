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
        useIR = true
    }
    buildFeatures {
        compose =  true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.0"
        kotlinCompilerVersion =  "1.5.10"
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
    implementation (libs.lifecycle.runtime)
    implementation (libs.activity.compose)
    testImplementation (libs.junit)
    androidTestImplementation (libs.test.ext)
    androidTestImplementation (libs.test.espresso)
    androidTestImplementation (libs.compose.test)
    debugImplementation (libs.compose.tool)
}