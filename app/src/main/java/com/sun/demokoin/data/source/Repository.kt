package com.sun.demokoin.data.source

class Repository(private val remote: DataSource.Remote) {

    suspend fun getRecipe() = remote.getRecipe()
}
