package com.oppo.community.core.common.utils.activityresult

import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.contract.ActivityResultContracts
import com.oppo.community.core.common.utils.EXTERNAL_MEDIA_IMAGES_URI

fun ActivityResultCaller.registerForTakePictureResult(callback: ActivityResultCallback<Boolean>) =
    SaveToUriLauncher(
        registerForActivityResult(ActivityResultContracts.TakePicture(), callback),
        EXTERNAL_MEDIA_IMAGES_URI,
        "jpg"
    )
