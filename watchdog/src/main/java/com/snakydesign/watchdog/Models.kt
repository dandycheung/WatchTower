package com.snakydesign.watchdog

/**
 * @author Adib Faramarzi (adibfara@gmail.com)
 */

sealed class NetworkContent

object EmptyBody : NetworkContent()
data class ContentBody(val contentLength: Long, val body: String, val gzippedLength: Long?) :
    NetworkContent()

data class HeaderData(val key: String, val value: String)
data class RequestData(
    val url: String,
    val headers: List<HeaderData>,
    val body: NetworkContent,
    val requestTime: Long,
    val method: String
)

data class ResponseData(
    val requestData: RequestData,
    val headers: List<HeaderData>,
    val body: NetworkContent,
    val tookTime: Long,
    val responseCode: Int,
    val contentLength: Long
)
