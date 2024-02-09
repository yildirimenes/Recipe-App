package com.yildirim.recipeapp.retrofit

import com.yildirim.recipeapp.entity.FoodsResponse
import retrofit2.Call
import retrofit2.http.GET

interface FoodsDaoInterface {
    @GET("foods/getAllFoods.php")
    fun allFoods(): Call<FoodsResponse>

}
