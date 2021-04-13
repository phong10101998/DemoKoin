package com.sun.demokoin.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sun.demokoin.R
import com.sun.demokoin.data.model.Recipe
import com.sun.demokoin.utils.Constant
import com.sun.demokoin.utils.loadUrl
import kotlinx.android.synthetic.main.item_recipe.view.*

class RecipeAdapter(
    private val onItemClicked: (Recipe) -> Unit
) : ListAdapter<Recipe, RecipeAdapter.RecipeByIngredientViewHolder>(RecipeDiffUtil()) {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): RecipeByIngredientViewHolder {
        return RecipeByIngredientViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_recipe, parent, false), onItemClicked
        )
    }

    override fun onBindViewHolder(holder: RecipeByIngredientViewHolder, position: Int) {
        holder.bindData((getItem(position)))
    }

    class RecipeByIngredientViewHolder(
        itemView: View, private val onItemClicked: (Recipe) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        fun bindData(recipe: Recipe) {
            itemView.apply {
                recipe.image?.let { imgDish.loadUrl(it) }
                textTimeCook.text = context.getString(R.string.ready_in_minute, recipe.timeCook)
                textTitleDish.text = recipe.title
                setOnClickListener {
                    onItemClicked(recipe)
                }
            }
        }
    }
}
