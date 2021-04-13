package com.sun.demokoin.data.source

import com.sun.demokoin.data.model.RecipeResponse
import retrofit2.Response

interface DataSource {
        interface Remote{
             suspend fun getRecipe(): Response<RecipeResponse>
        }
}
