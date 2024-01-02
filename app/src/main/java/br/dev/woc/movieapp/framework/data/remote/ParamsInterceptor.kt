package br.dev.woc.movieapp.framework.data.remote

import br.dev.woc.movieapp.BuildConfig
import br.dev.woc.movieapp.framework.util.Constants
import okhttp3.Interceptor
import okhttp3.Response

class ParamsInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter(Constants.LANGUAGE_PARAM, Constants.LANGUAGE_VALUE)
            .addQueryParameter(Constants.API_KEY_PARAM, BuildConfig.API_KEY)
            .build()

        val newRquest = request.newBuilder()
            .url(url)
            .build()

        return chain.proceed(newRquest)
    }
}