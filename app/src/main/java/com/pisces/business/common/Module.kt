package com.pisces.business.common

import com.pisces.business.data.FriendRepository
import com.pisces.business.data.FriendRepositoryImpl
import com.pisces.business.domain.FetchFriendsUseCase
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
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
    single<FriendRepository> { FriendRepositoryImpl(get()) }
    single { FetchFriendsUseCase(get(), get(named("IoDispatcher"))) }
}


fun provideOkhttpClient(): OkHttpClient = OkHttpClient.Builder().build()

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder().client(okHttpClient).baseUrl("").build()

fun provideBusinessService(retrofit: Retrofit): BusinessService = retrofit.create(BusinessService::class.java)

