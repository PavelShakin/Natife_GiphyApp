package com.giphyapp.buildSrc

object Dependencies {

    /**
     * com.giphyapp.buildSrc.Dependencies: Android base libraries
     */
    object AndroidBase {
        const val ktx = ("androidx.core:core-ktx:1.10.1")
        const val appcompat = ("androidx.appcompat:appcompat:1.6.1")
        const val constraintLayout = ("androidx.constraintlayout:constraintlayout:2.2.0-alpha12")
        const val kotlinxMetadataJvm = ("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.5.0")
    }

    /**
     * com.giphyapp.buildSrc.Dependencies: Compose
     */
    object Compose {
        private const val version = "1.5.0"
        private const val material3Version = "1.1.1"
        const val compileVersion = "1.5.3"
        const val activityVersion = "1.7.2"
        const val ui = ("androidx.compose.ui:ui:$version")
        const val activity = ("androidx.activity:activity-compose:$activityVersion")
        const val material3 = ("androidx.compose.material3:material3:$material3Version")
        const val tooling = ("androidx.compose.ui:ui-tooling-preview:$version")
        const val runtime = ("androidx.compose.runtime:runtime:$version")
        const val livedata = ("androidx.compose.runtime:runtime-livedata:$version")
        const val foundation = ("androidx.compose.foundation:foundation:$version")
        const val compiler = ("androidx.compose.compiler:compiler:$compileVersion")
    }

    /**
     * com.giphyapp.buildSrc.Dependencies: Coroutines
     */
    object Coroutines {
        private const val version = "1.7.3"
        const val core = ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$version")
        const val android = ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$version")
        const val test = ("org.jetbrains.kotlinx:kotlinx-coroutines-test:$version")
    }

    /**
     * com.giphyapp.buildSrc.Dependencies: Dependency injection
     */
    object DI {
        private const val version = "2.48"
        const val dagger = ("com.google.dagger:dagger:$version")
        const val daggerCompiler = ("com.google.dagger:dagger-compiler:$version")
        const val daggerSupport = ("com.google.dagger:dagger-android-support:$version")
        const val daggerAndroidProcessor = ("com.google.dagger:dagger-android-processor:$version")
    }

    /**
     * com.giphyapp.buildSrc.Dependencies: Dependency injection
     */
    object Lifecycle {
        private const val version = "2.6.1"
        const val viewModel = ("androidx.lifecycle:lifecycle-viewmodel-ktx:$version")
        const val viewModelCompose = ("androidx.lifecycle:lifecycle-viewmodel-compose:$version")
        const val livedata = ("androidx.lifecycle:lifecycle-livedata-ktx:$version")
        const val runtime = ("androidx.lifecycle:lifecycle-runtime-ktx:$version")
        const val compiler = ("androidx.lifecycle:lifecycle-compiler:$version")
        const val viewModelSavedState =
            ("androidx.lifecycle:lifecycle-viewmodel-savedstate:$version")
    }

    /**
     * com.giphyapp.buildSrc.Dependencies: Navigation
     */
    object Navigation {
        private const val version = "2.7.1"
        const val fragment = ("androidx.navigation:navigation-fragment-ktx:$version")
        const val ui = ("androidx.navigation:navigation-ui-ktx:$version")
        const val testing = ("androidx.navigation:navigation-testing:$version")
        const val compose = ("androidx.navigation:navigation-compose:$version")
    }

    /**
     * com.giphyapp.buildSrc.Dependencies: Tests
     */
    object Tests {
        const val junit = ("junit:junit:4.13.2")
        const val extJunit = ("androidx.test.ext:junit:1.1.5")
        const val espressoCore = ("androidx.test.espresso:espresso-core:3.5.1")
    }

    /**
     * com.giphyapp.buildSrc.Dependencies: Rettofit
     */
    object Retrofit {
        private const val version = "2.9.0"
        const val retrofit = ("com.squareup.retrofit2:retrofit:$version")
        const val converterGson = ("com.squareup.retrofit2:converter-gson:$version")
    }

    /**
     * com.giphyapp.buildSrc.Dependencies: Coil
     */
    object Coil {
        private const val version = "2.4.0"
        const val coil = ("io.coil-kt:coil-compose:$version")
        const val coilGif = ("io.coil-kt:coil-gif:$version")
    }


    /**
     * com.giphyapp.buildSrc.Dependencies: Modules
     */
    object Modules {
        val core = mapOf("path" to ":core")
        val data = mapOf("path" to ":data")
        val domain = mapOf("path" to ":domain")
        val gif = mapOf("path" to ":gif")
        val network = mapOf("path" to ":network")
        val resources = mapOf("path" to ":resources")
    }
}