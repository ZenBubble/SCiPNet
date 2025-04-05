package com.example.scipnet.viewscp.data

data class PageInfo(
    var link: String?
) {
    var httpStatusCode: Int = 0
    var httpStatusMessage: String = ""
    var title: String = ""
    var data: String = ""
}