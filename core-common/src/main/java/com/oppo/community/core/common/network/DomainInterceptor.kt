package com.oppo.community.core.common.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class DomainInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        TODO("Not yet implemented")
    }

    fun obtainDomainNameFromHeaders(request: Request): String? {
        val headers: List<String> = request.headers(DOMAIN_NAME)
        if (headers.isEmpty()) return null
        require(headers.size <= 1) { "Only one Domain-Name in the headers" }
        return request.header(DOMAIN_NAME)
    }

    companion object {
        private const val DOMAIN_NAME = "Domain-Name"
    }
}