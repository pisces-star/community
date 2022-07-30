package com.oppo.community.core.common.loadingview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oppo.community.core.common.R

class LoadingViewDelegate : LoadingStateView.ViewDelegate(ViewType.LOADING) {
    override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup): View =
        inflater.inflate(R.layout.layout_loading, parent, false)
}