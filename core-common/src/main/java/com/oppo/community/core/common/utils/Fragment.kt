
@file:Suppress("unused", "UNCHECKED_CAST")

package com.oppo.community.core.common.utils

import androidx.annotation.StringRes
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

fun <T : Fragment> T.withArguments(vararg pairs: Pair<String, *>) = apply {
    arguments = bundleOf(*pairs)
}

fun <T> Fragment.arguments(key: String) = lazy<T?> {
    arguments?.get(key) as T?
}

fun <T> Fragment.arguments(key: String, default: T) = lazy {
    arguments?.get(key) ?: default
}

fun <T> Fragment.safeArguments(name: String) = lazy<T> {
    checkNotNull(arguments?.get(name) as T) { "No intent value for key \"$name\"" }
}

fun Fragment.pressBackTwiceToExitApp(toastText: String, delayMillis: Long = 2000) =
    requireActivity().pressBackTwiceToExitApp(toastText, delayMillis, viewLifecycleOwner)

fun Fragment.pressBackTwiceToExitApp(@StringRes toastText: Int, delayMillis: Long = 2000) =
    requireActivity().pressBackTwiceToExitApp(toastText, delayMillis, viewLifecycleOwner)

fun Fragment.pressBackTwiceToExitApp(delayMillis: Long = 2000, onFirstBackPressed: () -> Unit) =
    requireActivity().pressBackTwiceToExitApp(delayMillis, viewLifecycleOwner, onFirstBackPressed)

fun Fragment.pressBackToNotExitApp() =
    requireActivity().pressBackToNotExitApp(viewLifecycleOwner)

fun Fragment.doOnBackPressed(onBackPressed: () -> Unit) =
    requireActivity().doOnBackPressed(viewLifecycleOwner, onBackPressed)
