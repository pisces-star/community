package com.oppo.community.core.common.utils.activityresult

import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.contract.ActivityResultContracts

fun ActivityResultCaller.registerForStartIntentSenderResult(callback: ActivityResultCallback<ActivityResult>) =
    registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult(), callback)
