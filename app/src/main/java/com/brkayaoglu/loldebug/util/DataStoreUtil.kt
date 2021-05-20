package com.brkayaoglu.loldebug.util

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import javax.inject.Inject

class DataStoreUtil
@Inject
constructor(
    val dataStore: DataStore<Preferences>,
) {

    suspend fun clearDataStore() {
        dataStore.edit {
            it.clear()
        }
    }

}