package com.example.scipnet.viewscp.data

import it.skrape.core.htmlDocument
import it.skrape.fetcher.BrowserFetcher
import it.skrape.fetcher.response
import it.skrape.fetcher.skrape
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PageParser(link: String?) {
    var page = PageInfo(link)
    init {
        GlobalScope.launch{fetchData(link)}
        //    Log.d("SCPTITLE", extracted.title)
        //    Log.d("SCPDATA", extracted.data
    }
    fun getTitle(): String {
        return page.title
    }
    fun getBody(): String {
        return page.data
    }
    suspend fun fetchData(link: String?) {
        skrape(BrowserFetcher) {
            request {
                url = link.toString()
            }
            response {
                htmlDocument{
                    page.title = "#page-title" { findFirst { text } }
                    page.data = "#page-content" { findFirst { text } }
                }
            }
        }
    }

}
