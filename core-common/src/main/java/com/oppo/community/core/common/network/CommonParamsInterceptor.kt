package com.oppo.community.core.common.network

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import okhttp3.Interceptor
import okhttp3.Response

class CommonParamsInterceptor(private val datastore: DataStore<Preferences>) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val oldRequest = chain.request()


        val request = when (oldRequest.method) {
            "GET" -> {
                oldRequest.newBuilder().url(oldRequest.url).build()
            }
            "POST" -> {
                oldRequest
            }
            else -> oldRequest

        }

        return chain.proceed(request)
    }
}