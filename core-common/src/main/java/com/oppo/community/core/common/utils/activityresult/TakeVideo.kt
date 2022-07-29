package com.oppo.community.core.common.utils.activityresult

import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.contract.ActivityResultContracts
import com.oppo.community.core.common.utils.EXTERNAL_MEDIA_VIDEO_URI

fun ActivityResultCaller.registerForTakeVideoResult(callback: ActivityResultCallback<Boolean>) =
    SaveToUriLauncher(
        registerForActivityResult(ActivityResultContracts.CaptureVideo(), callback),
        EXTERNAL_MEDIA_VIDEO_URI,
        "mp4"
    )
