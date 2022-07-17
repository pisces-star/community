package com.oppo.community.core.common.network

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import timber.log.Timber
import java.time.Duration


fun provideOkhttpClient(vararg interceptors: Interceptor): OkHttpClient {
    val logging = HttpLoggingInterceptor {
        Timber.tag("OkHttp").d(it)
    }
    logging.level = HttpLoggingInterceptor.Level.BODY
    val builder = OkHttpClient
        .Builder()
        .callTimeout(Duration.ofMinutes(TIMEOUT_LENGTH))
        .writeTimeout(Duration.ofMinutes(TIMEOUT_LENGTH))
        .readTimeout(Duration.ofMinutes(TIMEOUT_LENGTH))
        .retryOnConnectionFailure(true)
        .addInterceptor(logging)
        .addNetworkInterceptor(StethoInterceptor())

    interceptors.onEach {
        builder.addInterceptor(it)
    }
    return builder.build()
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    val contentType = "application/json".toMediaType()
    val format = Json { ignoreUnknownKeys = true }
    return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(format.asConverterFactory(contentType))
        .build()
}


fun <T> Retrofit.createService(clazz: Class<T>) = create(clazz)


private const val TIMEOUT_LENGTH = 2L
private const val BASE_URL = ""