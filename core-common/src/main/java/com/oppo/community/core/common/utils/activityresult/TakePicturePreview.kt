package com.oppo.community.core.common.utils.activityresult

import android.graphics.Bitmap
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.contract.ActivityResultContracts

fun ActivityResultCaller.registerForTakePicturePreviewResult(callback: ActivityResultCallback<Bitmap?>) =
    registerForActivityResult(ActivityResultContracts.TakePicturePreview(), callback)
