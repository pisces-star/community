package com.oppo.community.core.common.utils.activityresult

import android.net.Uri
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.contract.ActivityResultContracts
import com.oppo.community.core.common.utils.activityresult.MediaUriResultLauncher

fun ActivityResultCaller.registerForGetMultipleContentsResult(callback: ActivityResultCallback<List<Uri>>) =
    MediaUriResultLauncher(registerForActivityResult(ActivityResultContracts.GetMultipleContents(), callback))
