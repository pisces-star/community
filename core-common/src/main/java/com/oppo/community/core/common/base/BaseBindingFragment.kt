package com.oppo.community.core.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.oppo.community.core.common.binding.FragmentBinding
import com.oppo.community.core.common.binding.FragmentBindingDelegate
import com.oppo.community.core.common.loadingview.*
import com.oppo.community.core.common.network.Result

abstract class BaseBindingFragment<VB : ViewBinding> : Fragment(),
    LoadingState by LoadingStateDelegate(), OnReloadListener, Decorative,
    FragmentBinding<VB> by FragmentBindingDelegate() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return createViewWithBinding(inflater, container).decorate(this, this)
    }

    /**
     * 更新empty缺省页内容
     * @param iconRes
     * @param hintRes
     */
    protected fun updateEmpty(@DrawableRes iconRes: Int? = null, @StringRes hintRes: Int? = null) {
        updateView<ErrorViewDelegate>(ViewType.ERROR) {
            update(iconRes, hintRes)
        }
    }


    /**
     * 根据请求结果切换页面状态
     * @param state 请求结果
     */
    protected fun switchState(state: Result<*>) {
        when (state) {
            Result.Empty -> showEmptyView()
            is Result.Fail, is Result.Error -> showErrorView()
            Result.Loading -> showLoadingView()
            is Result.Success -> showContentView()
        }
    }
}

