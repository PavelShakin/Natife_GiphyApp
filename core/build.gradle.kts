import com.giphyapp.buildSrc.Config
import com.giphyapp.buildSrc.Dependencies

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = Config.Modules.application
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
        viewBinding = true
        compose = true
    }
}

dependencies {
    //region Modules
    implementation(project(Dependencies.Modules.resources))
//    implementation(project(Dependencies.Modules.data))
//    implementation(project(Dependencies.Modules.domain))
    //endregion

    //region AndroidBase
    implementation(Dependencies.AndroidBase.ktx)
    implementation(Dependencies.AndroidBase.appcompat)
    implementation(Dependencies.AndroidBase.constraintLayout)
    runtimeOnly(Dependencies.AndroidBase.kotlinxMetadataJvm)
    //endregion

    //region DI
    implementation(Dependencies.DI.dagger)
    implementation(Dependencies.DI.daggerSupport)
    kapt(Dependencies.DI.daggerCompiler)
    kapt(Dependencies.DI.daggerAndroidProcessor)
    //endregion

    //region Lifecycle
    implementation(Dependencies.Lifecycle.runtime)
    implementation(Dependencies.Lifecycle.livedata)
    implementation(Dependencies.Lifecycle.viewModel)
    implementation(Dependencies.Lifecycle.viewModelCompose)
    implementation(Dependencies.Lifecycle.viewModelSavedState)
    kapt(Dependencies.Lifecycle.compiler)
    //endregion

    //region Navigation
    implementation(Dependencies.Navigation.fragment)
    implementation(Dependencies.Navigation.ui)
    implementation(Dependencies.Navigation.compose)
    implementation(Dependencies.Navigation.testing)
    //endregion

    //region Tests
    testImplementation(Dependencies.Tests.junit)
    androidTestImplementation(Dependencies.Tests.extJunit)
    androidTestImplementation(Dependencies.Tests.espressoCore)
    //endregion
}
