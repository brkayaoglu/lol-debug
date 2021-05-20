package com.brkayaoglu.loldebug.core.network

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

import javax.inject.Inject

class LocalDataSource @Inject constructor(){

    fun <Database> buildDatabase(
        database: Class<Database>,
        context: Context,
        databaseName:String
    ): Database {
        val builder = Room.databaseBuilder(
            context,
            database as Class<RoomDatabase>,
            databaseName
        ).build()
        return builder as Database
    }

}