package com.oppo.community.core.common.utils.activityresult

import android.net.Uri
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.contract.ActivityResultContracts
import com.oppo.community.core.common.utils.activityresult.MediaUriResultLauncher

fun ActivityResultCaller.registerForGetContentResult(callback: ActivityResultCallback<Uri?>) =
    MediaUriResultLauncher(registerForActivityResult(ActivityResultContracts.GetContent(), callback))
