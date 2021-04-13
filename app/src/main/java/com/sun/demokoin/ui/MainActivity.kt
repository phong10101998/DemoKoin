package com.sun.demokoin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sun.demokoin.R
import com.sun.demokoin.utils.Status
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: RecipeAdapter

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnButton.setOnClickListener { mainViewModel.fetchRecipes() }
        registerObserver()
    }

    private fun registerObserver() {
        mainViewModel.recipes.observe(this, {
            when (it.status) {
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                Status.SUCCESS -> {
                    adapter = RecipeAdapter { }
                    adapter.submitList(it.data?.body()?.recipes)
                    recyclerView.adapter = adapter
                    progressBar.visibility = View.GONE
                    recyclerView.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    progressBar.visibility = View.GONE
                    recyclerView.visibility = View.GONE
                }
            }
        })
    }
}
