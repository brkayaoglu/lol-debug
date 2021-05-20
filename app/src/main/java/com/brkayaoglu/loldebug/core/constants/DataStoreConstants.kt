package com.brkayaoglu.loldebug.core.constants

import androidx.datastore.preferences.core.stringPreferencesKey

class DataStoreConstants {
    companion object{

        const val DATA_STORE_NAME = "main_data_store"

        const val DEFAULT_MEAL_TYPE = "main course"
        const val DEFAULT_DIET_TYPE = "gluten free"

        const val MEAL_TYPE = "mealType"
        const val DIET_TYPE = "dietType"
        const val MEAL_TYPE_ID = "mealTypeId"
        const val DIET_TYPE_ID = "dietTypeId"

    }
}