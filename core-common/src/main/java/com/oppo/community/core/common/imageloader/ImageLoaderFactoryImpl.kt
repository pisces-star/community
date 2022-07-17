package com.oppo.community.core.common.imageloader

import android.content.Context
import coil.ImageLoader
import coil.ImageLoaderFactory

class ImageLoaderFactoryImpl(private val  context: Context) : ImageLoaderFactory {
    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(context)
            .crossfade(true)
            .build()
    }
}