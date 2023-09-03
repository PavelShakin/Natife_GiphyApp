import com.giphyapp.buildSrc.Config
import com.giphyapp.buildSrc.Dependencies

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = Config.Modules.resources
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = Config.testInstrumentationRunner
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

    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Compose.compileVersion
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
//region Modules
//    implementation(project(Dependencies.Modules.core))
//    implementation(project(Dependencies.Modules.data))
//    implementation(project(Dependencies.Modules.domain))
    //endregion

    //region AndroidBase
    implementation(Dependencies.AndroidBase.ktx)
    implementation(Dependencies.AndroidBase.appcompat)
    implementation(Dependencies.AndroidBase.constraintLayout)
    runtimeOnly(Dependencies.AndroidBase.kotlinxMetadataJvm)
    //endregion

    //region Compose
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.activity)
    implementation(Dependencies.Compose.material3)
    implementation(Dependencies.Compose.tooling)
    implementation(Dependencies.Compose.livedata)
    implementation(Dependencies.Compose.compiler)
    //endregion

    //region Tests
    testImplementation(Dependencies.Tests.junit)
    androidTestImplementation(Dependencies.Tests.extJunit)
    androidTestImplementation(Dependencies.Tests.espressoCore)
    //endregion
}
