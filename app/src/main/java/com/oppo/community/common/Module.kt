package com.oppo.community.common

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.oppo.community.data.SeaCreatureRepository
import com.oppo.community.data.SeaCreatureRepositoryImpl
import com.oppo.community.domain.FetchSeaCreaturesUseCase
import com.oppo.community.ui.home.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val module = module {
    factory(named("IoDispatcher")) { Dispatchers.IO }
    factory(named("DefaultDispatcher")) { Dispatchers.Default }
    factory(named("MainDispatcher")) { Dispatchers.Main }
    factory(named("MainImmediateDispatcher")) { Dispatchers.Main.immediate }
    single { provideOkhttpClient() }
    factory { provideRetrofit(get()) }
    single { provideBusinessService(get()) }
    single<SeaCreatureRepository> { SeaCreatureRepositoryImpl(get()) }
    factory { FetchSeaCreaturesUseCase(get(), get(named("IoDispatcher"))) }
    viewModel { HomeViewModel(get()) }
}

const val BASE_URL = "https://acnhapi.com/v1/"
fun provideOkhttpClient(): OkHttpClient = OkHttpClient.Builder().build()

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    val contentType = "application/json".toMediaType()
    return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(Json.asConverterFactory(contentType))
        .build()
}


fun provideBusinessService(retrofit: Retrofit): CommunityService = retrofit.create(CommunityService::class.java)

