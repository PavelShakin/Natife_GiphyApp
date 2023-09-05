package com.giphyapp.network.config

object GifAPI {
    const val API_TOKEN = "BIuXBv3oqWb1rMfPQbSsoiC3VqyzZL3B"
    private const val BASE_URL = "https://api.giphy.com"
    const val TRENDING = "/v1/gifs/trending"
    fun getBaseUrl(): String {
        return BASE_URL
    }
}
