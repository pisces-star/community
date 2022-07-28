package com.oppo.community.core.common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.oppo.community.core.common.binding.ActivityBinding
import com.oppo.community.core.common.binding.ActivityBindingDelegate
import com.oppo.community.core.common.loadingview.Decorative
import com.oppo.community.core.common.loadingview.LoadingState
import com.oppo.community.core.common.loadingview.LoadingStateDelegate
import com.oppo.community.core.common.loadingview.OnReloadListener


abstract class BaseBindingActivity<VB : ViewBinding> : AppCompatActivity(),
    LoadingState by LoadingStateDelegate(), OnReloadListener, Decorative,
    ActivityBinding<VB> by ActivityBindingDelegate() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentViewWithBinding()
        binding.root.decorate(this, this)
    }
}