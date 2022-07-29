@file:Suppress("unused")

package com.oppo.community.core.common.utils

inline fun <T> Array<T>.percentage(predicate: (T) -> Boolean) =
    filter(predicate).size.toFloat() / size
