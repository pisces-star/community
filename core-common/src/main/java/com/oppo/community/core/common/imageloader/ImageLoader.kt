package com.oppo.community.core.common.imageloader

import android.content.Context
import android.graphics.Color
import android.widget.ImageView
import androidx.annotation.ColorInt
import androidx.annotation.Px
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import jp.wasabeef.transformers.coil.BlurTransformation
import jp.wasabeef.transformers.coil.CropCircleWithBorderTransformation


fun ImageView.loadBorderImage(
    data: Any?,
    borderSize: Int = 4,
    @ColorInt borderColor: Int = Color.WHITE,
) {
    load(data) {
        transformations(CropCircleWithBorderTransformation(borderSize, borderColor))
    }
}

fun ImageView.loadCircleImage(data: Any?) {
    load(data) {
        transformations(CircleCropTransformation())
    }
}


fun ImageView.loadRoundCornerImage(data: Any?, @Px radius: Float) {
    load(data) {
        transformations(RoundedCornersTransformation(radius))
    }
}


fun ImageView.loadBlurImage(
    data: Any?,
    context: Context,
    radius: Int = 25,
    sampling: Int = 1,
) {
    load(data) {
        transformations(BlurTransformation(context, radius, sampling))
    }
}