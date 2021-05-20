package com.brkayaoglu.loldebug.core.base

import android.app.Application
import androidx.lifecycle.*
import com.brkayaoglu.loldebug.util.NetworkListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class BaseViewModel(
    private val repository: BaseRepository, application: Application
) : AndroidViewModel(application) {

    private lateinit var networkListener: NetworkListener

    private val _networkConnection: MutableLiveData<Boolean> = MutableLiveData()
    val networkConnection: LiveData<Boolean>
        get() = _networkConnection

    fun checkNetworkConnection(){
        viewModelScope.launch {
            networkListener = NetworkListener()
            networkListener.checkNetworkAvailability(this@BaseViewModel.getApplication<Application>().applicationContext)
                .collect {status->
                    _networkConnection.value = status
                }
        }
    }

}
