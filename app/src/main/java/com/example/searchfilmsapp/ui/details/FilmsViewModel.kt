package com.example.searchfilmsapp.ui.details

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.searchfilmsapp.model.AppState
import com.example.searchfilmsapp.model.Repository
import com.example.searchfilmsapp.model.RepositoryImpl

class FilmsViewModel : ViewModel(), LifecycleObserver {
    private val repository: Repository = RepositoryImpl()
    val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()

    fun loadData(categories : String) {
        liveDataToObserve.value = AppState.Loading
        Thread {
            val data = repository.getFilmsFromServer(categories)
            liveDataToObserve.postValue(AppState.Success(listOf(data)))
        }.start()
    }

}