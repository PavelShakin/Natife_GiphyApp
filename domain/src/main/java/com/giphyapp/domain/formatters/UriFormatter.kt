package com.giphyapp.domain.formatters

import com.giphyapp.core.common.GlobalConstants.formatterPattern
import com.giphyapp.core.formatters.IUriFormatter

class UriFormatter : IUriFormatter {

    override fun getCorrectLink(link: String): String {
        return link.substringBefore(formatterPattern)
    }
}
