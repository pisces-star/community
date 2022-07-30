package com.oppo.community.core.common.loadingview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import com.oppo.community.core.common.databinding.LayoutToolbarBinding

var ToolbarConfig.menuId: Int? by toolbarExtras()
var ToolbarConfig.onMenuItemClick: Toolbar.OnMenuItemClickListener? by toolbarExtras()

class ToolbarViewDelegate : BaseToolbarViewDelegate() {
    private lateinit var binding: LayoutToolbarBinding

    override fun onCreateToolbar(inflater: LayoutInflater, parent: ViewGroup): View {
        binding = LayoutToolbarBinding.inflate(inflater, parent, false)
        return binding.root
    }

    @SuppressLint("ResourceType")
    override fun onBindToolbar(config: ToolbarConfig) {
        binding.root.apply {
            title = config.title
            config.navIcon?.let { setNavigationIcon(it) }
            setNavigationOnClickListener { config.onNavClickListener }

            config.menuId?.let {
                inflateMenu(id)
                config.onMenuItemClick?.let {
                    setOnMenuItemClickListener(it)
                }
            }

        }
    }
}