package com.oppo.community.core.common.base

import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.annotation.MenuRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewbinding.ViewBinding
import com.oppo.community.core.common.binding.ActivityBinding
import com.oppo.community.core.common.binding.ActivityBindingDelegate
import com.oppo.community.core.common.loadingview.*
import com.oppo.community.core.common.network.Result


abstract class BaseBindingActivity<VB : ViewBinding> : AppCompatActivity(),
    LoadingState by LoadingStateDelegate(), OnReloadListener, Decorative,
    ActivityBinding<VB> by ActivityBindingDelegate() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentViewWithBinding()
        binding.root.decorate(this, this)
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

    /**
     * 配置toolbar
     * @param title
     * @param backRes navIcon
     * @param menu menuId
     * @param menuClick
     */
    protected fun configTitle(
        @StringRes title: Int,
        @DrawableRes backRes: Int? = null,
        @MenuRes menu: Int? = null,
        menuClick: Toolbar.OnMenuItemClickListener? = null
    ) {
        setToolbar(title) {
            navIcon = backRes
            menuId = menu
            onMenuItemClick = menuClick
        }
    }
}