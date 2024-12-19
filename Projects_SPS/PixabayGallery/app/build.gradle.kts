plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.example.pixabaygallery"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.pixabaygallery"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
}

dependencies {


    implementation(libs.androidx.core.ktx.v1120)
    implementation(libs.androidx.lifecycle.runtime.ktx.v262)
    implementation(libs.androidx.activity.compose.v180)


    implementation(libs.androidx.compose.bom.v20240100)
    implementation(libs.androidx.ui.v153)
    implementation(libs.androidx.material.v153)

    implementation(libs.ui.tooling.preview)
    debugImplementation(libs.androidx.ui.tooling.v153)
    debugImplementation(libs.ui.test.manifest)
    implementation(libs.androidx.material3.v100)


    implementation(libs.androidx.navigation.compose.v272)


    implementation(libs.retrofit)
    implementation(libs.converter.gson)


    implementation(libs.io.coil.kt.coil.compose)


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.v115)
    androidTestImplementation(libs.androidx.espresso.core.v351)
    androidTestImplementation(libs.ui.test.junit4)
}
