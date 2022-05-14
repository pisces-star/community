package com.pisces.business

import android.app.Application
import com.pisces.business.common.module
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BusinessApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            // Koin Android logger
            androidLogger()
            //inject Android context
            androidContext(this@BusinessApplication)
            // use modules
            modules(module)
        }

    }
}