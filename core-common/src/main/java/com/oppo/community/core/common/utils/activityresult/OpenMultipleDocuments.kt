package com.oppo.community.core.common.utils.activityresult

import android.net.Uri
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.contract.ActivityResultContracts

fun ActivityResultCaller.registerForOpenMultipleDocumentsResult(callback: ActivityResultCallback<List<Uri>>) =
    registerForActivityResult(ActivityResultContracts.OpenMultipleDocuments(), callback)
