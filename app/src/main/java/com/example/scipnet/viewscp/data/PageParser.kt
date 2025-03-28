package com.example.scipnet.viewscp.data

import it.skrape.core.htmlDocument
import it.skrape.fetcher.HttpFetcher
import it.skrape.fetcher.extract
import it.skrape.fetcher.response
import it.skrape.fetcher.skrape

class PageParser(link: String) {
    var page = PageInfo(link)
    init {
        val extracted = skrape(HttpFetcher) {
            request {
                url = link
            }
            response {
                htmlDocument{
                    page.title = "#page-title" { findFirst { text } }
                    page.data = "#page-content" { findFirst { text } }
                }
            }
        }
        //    Log.d("SCPTITLE", extracted.title)
        //    Log.d("SCPDATA", extracted.data
    }
    fun getTitle(): String {
        return page.title
    }
    fun getBody(): String {
        return page.data
    }
}
