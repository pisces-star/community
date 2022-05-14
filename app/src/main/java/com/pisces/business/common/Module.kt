package com.pisces.business.common

import com.pisces.business.data.FriendRepository
import com.pisces.business.data.FriendRepositoryImpl
import com.pisces.business.domain.FetchFriendsUseCase
import com.pisces.business.ui.home.HomeViewModel
import kotlinx.coroutines.Dispatchers
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
    single<FriendRepository> { FriendRepositoryImpl(get()) }
    factory { FetchFriendsUseCase(get(), get(named("IoDispatcher"))) }
    viewModel { HomeViewModel(get()) }
}


fun provideOkhttpClient(): OkHttpClient = OkHttpClient.Builder().build()

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder().client(okHttpClient).baseUrl("").build()

fun provideBusinessService(retrofit: Retrofit): BusinessService = retrofit.create(BusinessService::class.java)

