package com.sun.demokoin.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sun.demokoin.data.model.RecipeResponse
import com.sun.demokoin.data.source.Repository
import com.sun.demokoin.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    private val _recipes = MutableLiveData<Resource<Response<RecipeResponse>>>()
    val recipes: MutableLiveData<Resource<Response<RecipeResponse>>>
        get() = _recipes

    fun fetchRecipes() {
        viewModelScope.launch {
            _recipes.postValue(Resource.loading(null))
            try {
                _recipes.postValue(Resource.success(repository.getRecipe()))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
