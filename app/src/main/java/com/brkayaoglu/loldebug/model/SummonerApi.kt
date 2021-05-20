package com.brkayaoglu.loldebug.model

import com.brkayaoglu.loldebug.core.base.BaseAPI
import com.brkayaoglu.loldebug.core.constants.NetworkConstants
import retrofit2.http.GET
import retrofit2.http.Path

interface SummonerApi : BaseAPI {

    @GET("lol/summoner/v4/summoners/by-name/{summonerName}")
    suspend fun getSummoner(
        @Path("summonerName") summonerName: String
    ) : Summoner


}