package com.oppo.community.core.common.base

data class BaseResponse<T>(
    val code: Int,
    val data: T,
    val msg: String? = ""
) {
    val succeeded: Boolean = this.code == 200
}