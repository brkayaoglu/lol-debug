package com.brkayaoglu.loldebug.di


import com.brkayaoglu.loldebug.core.network.RemoteDataSource
import com.brkayaoglu.loldebug.model.SummonerApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRecipesApi(
        remoteDataSource: RemoteDataSource,
    ): SummonerApi {
        return remoteDataSource.buildApi(SummonerApi::class.java)
    }

}