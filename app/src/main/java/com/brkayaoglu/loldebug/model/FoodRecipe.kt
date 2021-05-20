package com.brkayaoglu.loldebug.model


import com.google.gson.annotations.SerializedName

data class FoodRecipe(
    @SerializedName("results")
    val results : List<Int>
)