package com.giphyapp.buildSrc

/**
 * App configuration properties uses in build .apk or .aab
 */
object Config {
    /**
     * com.giphyapp.buildSrc.Config: targetSdk
     */
    const val targetSdk = 34
    /**
     * com.giphyapp.buildSrc.Config: compileSdk
     */
    const val compileSdk = targetSdk
    /**
     * com.giphyapp.buildSrc.Config: min sdk support
     */
    const val minSdk = 30
    /**
     * com.giphyapp.buildSrc.Config: version code
     */
    const val versionCode = 33
    /**
     * com.giphyapp.buildSrc.Config: version name
     */
    private const val major = "0"
    private const val minor = "0"
    private const val path = "1"
    const val versionName = "$major.$minor.${path}"
    /**
     * com.giphyapp.buildSrc.Config: modules id
     */
    object Modules {
        const val application = "com.giphyapp.android"
        const val core = "com.giphyapp.core"
        const val gif = "com.giphyapp.gif"
        const val resources = "com.giphyapp.resources"
        const val data = "com.giphyapp.data"
        const val domain = "com.gpiphy.domain"
    }
    /**
     * com.giphyapp.buildSrc.Config: testInstrumentationRunner
     */
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}
