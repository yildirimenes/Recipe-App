package com.yildirim.recipeapp.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FoodsResponse(
    @SerializedName("foods")
    @Expose
    var foods: List<Foods>,
    @SerializedName("success")
    @Expose
    var success: Int
)
