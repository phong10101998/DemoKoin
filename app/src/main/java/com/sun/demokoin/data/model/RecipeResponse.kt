package com.sun.demokoin.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sun.demokoin.data.model.Recipe
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RecipeResponse(
    @SerializedName("recipes") @Expose val recipes: List<Recipe>
) : Parcelable
