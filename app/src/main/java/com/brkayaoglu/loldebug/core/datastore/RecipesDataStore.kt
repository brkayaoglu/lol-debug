package com.brkayaoglu.loldebug.core.datastore

import javax.inject.Inject
import com.brkayaoglu.loldebug.core.base.BaseDataStore
import com.brkayaoglu.loldebug.util.DataStoreUtil

class RecipesDataStore @Inject constructor(private val dataStore: DataStoreUtil) : BaseDataStore(){

    /*
    *private object PreferencesKeys{
        val selectedMealType = stringPreferencesKey(DataStoreConstants.MEAL_TYPE)
        val selectedMealTypeId = stringPreferencesKey(DataStoreConstants.MEAL_TYPE_ID)
        val selectedDietType = stringPreferencesKey(DataStoreConstants.DIET_TYPE)
        val selectedDietTypeId = stringPreferencesKey(DataStoreConstants.DIET_TYPE_ID)
    }

    suspend fun saveMealAndDietType(mealType:String, mealTypeId:Int, dietType:String, dietTypeId:Int){
        dataStore.setSecuredData(PreferencesKeys.selectedMealType,mealType)
        //dataStore.setSecuredData(PreferencesKeys.selectedMealTypeId,mealTypeId.toString())
        dataStore.setSecuredData(PreferencesKeys.selectedDietType,dietType)
        //dataStore.setSecuredData(PreferencesKeys.selectedDietTypeId,dietTypeId.toString())
    }

    val readMealAndDietType : MealAndDietType =
        MealAndDietType(
            dataStore.getSecuredData(PreferencesKeys.selectedMealTypeId,"1"),
            dataStore.getSecuredData(PreferencesKeys.selectedMealType,DataStoreConstants.DEFAULT_MEAL_TYPE),
            dataStore.getSecuredData(PreferencesKeys.selectedDietTypeId,"0"),
            dataStore.getSecuredData(PreferencesKeys.selectedDietType,DataStoreConstants.DEFAULT_DIET_TYPE),
        )

    data class MealAndDietType(
        val mealTypeId: String,
        val mealType: String,
        val dietTypeId: String,
        val dietType: String
    )
     */
}