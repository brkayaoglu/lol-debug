package com.brkayaoglu.loldebug.page.fragment.login

import com.brkayaoglu.loldebug.core.base.BaseRepository
import com.brkayaoglu.loldebug.model.SummonerApi
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class LoginRepository @Inject constructor(private val api: SummonerApi) : BaseRepository() {


    suspend fun getSummoner(summonerName:String) = request { api.getSummoner(summonerName) }


}