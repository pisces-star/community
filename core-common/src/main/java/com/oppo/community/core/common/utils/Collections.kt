@file:Suppress("unused")

package com.oppo.community.core.common.utils

inline fun <T> List<T>.percentage(predicate: (T) -> Boolean) =
    filter(predicate).size.toFloat() / size
