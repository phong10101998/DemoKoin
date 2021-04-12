package com.sun.demokoin.data.source.remote

import com.sun.demokoin.data.model.RecipeResponse
import com.sun.demokoin.data.source.DataSource
import com.sun.demokoin.data.source.remote.api.ApiService
import retrofit2.Response

class RemoteDataSource(private val apiService: ApiService) : DataSource.Remote {

    override suspend fun getRecipe(): Response<RecipeResponse> {
        return apiService.getRecipe()
    }
}
