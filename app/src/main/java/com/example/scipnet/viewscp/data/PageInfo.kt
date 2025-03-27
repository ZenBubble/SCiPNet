package com.example.scipnet.viewscp.data

import it.skrape.core.htmlDocument
import it.skrape.fetcher.HttpFetcher
import it.skrape.fetcher.extractIt
import it.skrape.fetcher.skrape

data class PageInfo(var link: String) {
    var title: String = ""
    var data: String = ""
    init {
        skrape(HttpFetcher) {
            request {
                url = link
            }
            extractIt<PageInfo> { res ->
                htmlDocument{
                    title = "#page-title" { findFirst { text } }
                    data = "#page-content" { findFirst { text } }
                }
            }
        }
//    Log.d("SCPTITLE", extracted.title)
//    Log.d("SCPDATA", extracted.data)
    }
}