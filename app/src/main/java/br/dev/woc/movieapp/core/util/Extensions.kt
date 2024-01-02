package br.dev.woc.movieapp.core.util

import br.dev.woc.movieapp.BuildConfig

fun String?.toPostUrl() = "${BuildConfig.BASE_URL_IMAGE}$this"
fun String?.toBackDropUrl() = "${BuildConfig.BASE_URL_IMAGE}$this"