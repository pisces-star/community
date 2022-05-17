package com.oppo.community

import android.app.Application
import com.didi.drouter.api.DRouter
import com.oppo.community.common.module
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CommunityApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DRouter.init(this)
        startKoin {
            // Koin Android logger
            androidLogger()
            //inject Android context
            androidContext(this@CommunityApplication)
            // use modules
            modules(module)
        }

    }
}