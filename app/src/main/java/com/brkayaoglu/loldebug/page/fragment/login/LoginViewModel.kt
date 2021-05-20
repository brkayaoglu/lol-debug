package com.brkayaoglu.loldebug.page.fragment.login

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.brkayaoglu.loldebug.core.base.BaseViewModel
import com.brkayaoglu.loldebug.model.ResponseStatus
import com.brkayaoglu.loldebug.model.Summoner
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: LoginRepository, application: Application) : BaseViewModel(repository, application) {


    private val _summoner: MutableLiveData<Summoner> = MutableLiveData()
    val summoner: LiveData<Summoner>
        get() = _summoner

    fun getSummoner(summonerName:String) = viewModelScope.launch {
        _summoner.value = handleResponse(repository.getSummoner(summonerName))
        /*
        if( _recipes.value != null){
            insertRecipesToDB(_recipes.value!!)
        }
         */
    }

    private fun handleResponse(response: ResponseStatus<Summoner>): Summoner? {
        return when{
            response is ResponseStatus.Success -> {
                response.value
            }
            else -> {
                null
            }
        }
    }

}