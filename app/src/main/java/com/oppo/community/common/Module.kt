package com.oppo.community.common

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.oppo.community.data.SeaCreatureRepository
import com.oppo.community.data.SeaCreatureRepositoryImpl
import com.oppo.community.domain.FetchSeaCreaturesUseCase
import com.oppo.community.ui.home.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import timber.log.Timber
import java.time.Duration

val module = module {
    factory(named(IO_DISPATCHER)) { Dispatchers.IO }
    factory(named(DEFAULT_DISPATCHER)) { Dispatchers.Default }
    factory(named(MAIN_DISPATCHER)) { Dispatchers.Main }
    factory(named(MAIN_IMMEDIATE_DISPATCHER)) { Dispatchers.Main.immediate }
    single { provideOkhttpClient() }
    factory { provideRetrofit(get()) }
    single { provideBusinessService(get()) }
    single<SeaCreatureRepository> { SeaCreatureRepositoryImpl(get()) }
    factory { FetchSeaCreaturesUseCase(get(), get(named(IO_DISPATCHER))) }
    viewModel { HomeViewModel(get()) }
}


const val PREFS_NAME = "community"
const val BASE_URL = "https://acnhapi.com/v1a/"
const val IO_DISPATCHER = "IoDispatcher"
const val DEFAULT_DISPATCHER = "DefaultDispatcher"
const val MAIN_DISPATCHER = "MainDispatcher"
const val MAIN_IMMEDIATE_DISPATCHER = "MainImmediateDispatcher"



fun provideOkhttpClient(): OkHttpClient {
    val logging = HttpLoggingInterceptor {
        Timber.tag("OkHttp").d(it)
    }
    logging.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient
        .Builder()
        .callTimeout(Duration.ofMinutes(2))
        .writeTimeout(Duration.ofMinutes(2))
        .readTimeout(Duration.ofMinutes(2))
        .retryOnConnectionFailure(true)
        .addInterceptor(logging)
        .addNetworkInterceptor(StethoInterceptor())
        .build()
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


fun provideBusinessService(retrofit: Retrofit): CommunityService = retrofit.create(CommunityService::class.java)

