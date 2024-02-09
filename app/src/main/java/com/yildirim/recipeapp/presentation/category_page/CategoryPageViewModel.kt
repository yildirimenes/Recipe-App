package com.yildirim.recipeapp.presentation.category_page

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yildirim.recipeapp.entity.Foods
import com.yildirim.recipeapp.repo.FoodsDaoRepository

class CategoryPageViewModel : ViewModel() {
    var foodsList = MutableLiveData<List<Foods>>()
    private var vrepo = FoodsDaoRepository()

    init {
        loadFoods()
        foodsList = vrepo.getFoods()
    }

    private fun loadFoods() {
        vrepo.allFoods()
    }
}