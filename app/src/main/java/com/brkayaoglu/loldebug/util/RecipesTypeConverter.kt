package com.brkayaoglu.loldebug.util


import com.google.gson.Gson


class RecipesTypeConverter {
    var gson = Gson()
    /*
    @TypeConverter
    fun foodRecipeToString(foodRecipe: FoodRecipe) : String{
        return gson.toJson(foodRecipe)
    }
    @TypeConverter
    fun stringToFoodRecipe(data:String) : FoodRecipe{
        var listType = object : TypeToken<FoodRecipe>(){}.type
        return gson.fromJson(data, listType )
    }
     */
}