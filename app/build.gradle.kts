plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.app.framematch"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.app.framematch"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)


    // If using direct dependency (if libs issue persists):
    // implementation("androidx.navigation:navigation-compose:2.5.3")

    // Navigation Compose Dependency (corrected)
    implementation(libs.androidx.navigation.compose)
    implementation ("androidx.compose.ui:ui:1.5.1")
    implementation ("androidx.compose.material3:material3:1.1.1")
    implementation ("androidx.compose.material:material-icons-extended:1.5.1")
    implementation ("androidx.navigation:navigation-compose:2.6.0")
    implementation ("androidx.navigation:navigation-compose:2.6.0")
    implementation ("androidx.navigation:navigation-compose:2.6.0")
    implementation ("androidx.compose.material3:material3:<latest_version>")
    implementation ("io.coil-kt:coil-compose:2.2.2")
    implementation("io.coil-kt:coil-compose:2.2.2") // Use the latest version
    implementation ("androidx.navigation:navigation-compose:2.7.0")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
