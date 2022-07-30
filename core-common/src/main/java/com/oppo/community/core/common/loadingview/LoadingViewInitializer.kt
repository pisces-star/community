package com.oppo.community.core.common.loadingview

import android.content.Context
import androidx.startup.Initializer

internal class LoadingViewInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        LoadingStateView.setViewDelegatePool {
            register(ToolbarViewDelegate(), LoadingViewDelegate(), ErrorViewDelegate(), EmptyViewDelegate())
        }
    }

    override fun dependencies() = emptyList<Class<Initializer<*>>>()
}
