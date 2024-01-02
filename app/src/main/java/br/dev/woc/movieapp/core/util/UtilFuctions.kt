package br.dev.woc.movieapp.core.util

import timber.log.Timber

object UtilFuctions {
    fun logError(tag: String, message: String) {
        Timber.tag(tag).e("Error -> $message")
    }

    fun logInfo(tag: String, message: String) {
        Timber.tag(tag).i("Info -> $message")
    }
}