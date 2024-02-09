package com.yildirim.recipeapp.repo

import androidx.lifecycle.MutableLiveData
import com.yildirim.recipeapp.entity.Foods
import com.yildirim.recipeapp.entity.FoodsResponse
import com.yildirim.recipeapp.retrofit.ApiUtils
import com.yildirim.recipeapp.retrofit.FoodsDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodsDaoRepository {
    var foodsList = MutableLiveData<List<Foods>>()
    private var foodsDaoInterface:FoodsDaoInterface = ApiUtils.getFoodsDaoInterface()

    init {
        foodsList = MutableLiveData()
    }

    fun getFoods(): MutableLiveData<List<Foods>> {
        return foodsList
    }

    fun allFoods() {
        foodsDaoInterface.allFoods().enqueue(object : Callback<FoodsResponse> {
            override fun onResponse(
                call: Call<FoodsResponse>?,
                response: Response<FoodsResponse>?
            ) {
                val list = response?.body()?.foods
                foodsList.value = list!!
            }

            override fun onFailure(call: Call<FoodsResponse>?, t: Throwable?) {
                TODO("Not yet implemented")
            }
        })
    }
}

