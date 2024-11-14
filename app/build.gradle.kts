plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.myhw_3"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.myhw_3"
        minSdk = 24
        //noinspection EditedTargetSdkVersion
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
}

dependencies {

    implementation ("androidx.compose.material3:material3:1.1.0") // Material 3
    implementation( "androidx.navigation:navigation-compose:2.7.4")
    // Jetpack Navigation
    implementation("androidx.navigation:navigation-compose:2.7.0") // Оставлена одна версия

    // Jetpack Compose
    implementation("androidx.compose.ui:ui:1.5.0")
    implementation("androidx.compose.material3:material3:1.2.0") // Обновлена версия
    implementation("androidx.compose.runtime:runtime:1.5.0")
    implementation("androidx.compose.foundation:foundation:1.5.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.0")

    // For image vector support
    implementation("androidx.compose.ui:ui-graphics:1.5.0")

    // Coil for image loading
    implementation("io.coil-kt:coil-compose:2.4.0")

    // Jetpack Compose Animation
    implementation("androidx.compose.animation:animation:1.5.0")

    // Kotlin Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")

    // Kotlin Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Kotlin Standard Library
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.10")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}