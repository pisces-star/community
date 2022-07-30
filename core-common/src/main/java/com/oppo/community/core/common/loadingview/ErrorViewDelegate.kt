package com.oppo.community.core.common.loadingview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.oppo.community.core.common.databinding.LayoutErrorBinding

class ErrorViewDelegate : LoadingStateView.ViewDelegate(ViewType.ERROR) {
    private lateinit var binding: LayoutErrorBinding
    override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup): View {
        binding = LayoutErrorBinding.inflate(inflater, parent, false).apply {
            root.setOnClickListener {
                onReloadListener?.onReload()
            }
        }
        return binding.root
    }

    fun update(@DrawableRes iconRes: Int?, @StringRes hintRes: Int?) {
        iconRes?.let {
            binding.ivErrorIcon.setImageResource(it)
        }

        hintRes?.let {
            binding.tvErrorText.setText(it)
        }
    }
}