package com.giphyapp.core.formatters

interface IUriFormatter {
    /**
     * Format uri from api
     */
    fun getCorrectLink(link: String): String
}