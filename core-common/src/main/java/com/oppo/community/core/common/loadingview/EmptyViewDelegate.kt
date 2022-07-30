package com.oppo.community.core.common.loadingview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oppo.community.core.common.R

class EmptyViewDelegate : LoadingStateView.ViewDelegate(ViewType.EMPTY) {
    override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup): View =
        inflater.inflate(R.layout.layout_empty, parent, false)
}