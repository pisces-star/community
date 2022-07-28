package com.oppo.community.core.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.oppo.community.core.common.binding.FragmentBinding
import com.oppo.community.core.common.binding.FragmentBindingDelegate
import com.oppo.community.core.common.loadingview.Decorative
import com.oppo.community.core.common.loadingview.LoadingState
import com.oppo.community.core.common.loadingview.LoadingStateDelegate
import com.oppo.community.core.common.loadingview.OnReloadListener

abstract class BaseBindingFragment<VB : ViewBinding> : Fragment(),
    LoadingState by LoadingStateDelegate(), OnReloadListener, Decorative,
    FragmentBinding<VB> by FragmentBindingDelegate() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return createViewWithBinding(inflater, container).decorate(this, this)
    }
}

