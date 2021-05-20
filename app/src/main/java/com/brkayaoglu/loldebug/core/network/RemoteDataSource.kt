package com.brkayaoglu.loldebug.core.network

import androidx.viewbinding.BuildConfig
import com.brkayaoglu.loldebug.core.constants.NetworkConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RemoteDataSource @Inject constructor(){

    fun <Api> buildApi(
        api: Class<Api>,
    ): Api {
        return Retrofit.Builder()
            .baseUrl(NetworkConstants.baseUrl)
            .client(getRetrofitClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }

    private fun getRetrofitClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                chain.proceed(chain.request().newBuilder().also {
                    it.addHeader(NetworkConstants.Headers.ACCEPT.key, NetworkConstants.Encoding.JSON.encoding)
                    it.addHeader(NetworkConstants.Headers.RIOT_TOKEN.key, NetworkConstants.API_KEY)
                }.build())
            }.also { client ->
                    if (BuildConfig.DEBUG) {
                        val logging = HttpLoggingInterceptor()
                        logging.apply { logging.level = HttpLoggingInterceptor.Level.BODY }
                        client.addInterceptor(logging)
                }
            }.build()
    }

}