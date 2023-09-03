package com.giphyapp.buildSrc

object AppPlugins {
    const val application = "com.android.application"
    const val library = "com.android.library"
    const val kotlin = "org.jetbrains.kotlin.android"
    const val kapt = "org.jetbrains.kotlin.kapt"
    const val navigation = "androidx.navigation.safeargs"
    const val detekt = "io.gitlab.arturbosch.detekt"
    const val ktLint = "org.jlleitschuh.gradle.ktlint"

    object Versions {
        const val android = "8.1.0"
        const val kotlin = "1.9.10"
        const val navigation = "2.7.1"
        const val detekt = "1.23.1"
        const val ktLint = "11.5.1"
    }
}