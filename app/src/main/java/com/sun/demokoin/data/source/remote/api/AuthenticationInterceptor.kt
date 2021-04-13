package com.sun.demokoin.data.source.remote.api

import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .addHeader("x-rapidapi-key", "220ae73fdcmsh1a0bf4875f67d5fp17df90jsn5d0863330dcb")
            .addHeader("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
            .build()
        return chain.proceed(newRequest)
    }
}
