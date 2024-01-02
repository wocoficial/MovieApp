package br.dev.woc.movieapp.core.util

sealed class ResultData<out T> {
    object Loading : ResultData<Nothing>()
    data class Sucess<out T>(val data: T?) : ResultData<T>()
    data class Failure(val e: Exception?) : ResultData<Nothing>()
}