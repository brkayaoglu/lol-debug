package com.brkayaoglu.loldebug.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.brkayaoglu.loldebug.core.constants.DataStoreConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataStoreModule {
    @Singleton
    @Provides
    fun buildDataStore(@ApplicationContext context: Context): DataStore<Preferences> =
        preferencesDataStore(DataStoreConstants.DATA_STORE_NAME).getValue(context, String::javaClass)
}