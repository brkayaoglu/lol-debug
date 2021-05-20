package com.brkayaoglu.loldebug.di


import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    /*
    @Singleton
    @Provides
    fun provideRoomDatabase(
        localDataSource: LocalDataSource,
        @ApplicationContext context: Context
    ) : RecipesDatabase = localDataSource.buildDatabase(RecipesDatabase::class.java,context, RoomConstants.DATABASE_NAME)
     */

}