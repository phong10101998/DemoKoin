package com.sun.demokoin.data.source.remote.api

import com.sun.demokoin.data.model.RecipeResponse
import com.sun.demokoin.utils.Constant
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("random?number=15")
    suspend fun getRecipe(): Response<RecipeResponse>
}
