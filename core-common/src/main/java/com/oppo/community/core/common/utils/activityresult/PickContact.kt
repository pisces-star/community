package com.oppo.community.core.common.utils.activityresult

import android.net.Uri
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.contract.ActivityResultContracts

fun ActivityResultCaller.registerForPickContactResult(callback: ActivityResultCallback<Uri?>) =
    registerForActivityResult(ActivityResultContracts.PickContact(), callback)
