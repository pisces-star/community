package com.oppo.community.core.common.loadingview

import android.view.View

interface Decorative {
    val isDecorated: Boolean get() = true
    val contentView: View? get() = null
}