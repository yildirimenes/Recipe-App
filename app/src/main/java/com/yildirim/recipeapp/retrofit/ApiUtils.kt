package com.yildirim.recipeapp.retrofit

class ApiUtils {
    companion object{
        private const val BASE_URL = "http://www.yildirimenes.com/"
        fun getFoodsDaoInterface() : FoodsDaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(FoodsDaoInterface::class.java)
        }
    }
}
