package com.example.searchfilmsapp.ui.main

import androidx.lifecycle.*
import com.example.searchfilmsapp.model.AppState
import com.example.searchfilmsapp.model.Repository
import com.example.searchfilmsapp.model.RepositoryImpl
import com.example.searchfilmsapp.strings_iteractor.StringsInteractor
import java.lang.Thread.sleep

class MainViewModel(private val liveDataToObserve: MediatorLiveData<AppState> = MediatorLiveData(),
//        private val repositoryImpl: Repository = RepositoryImpl()
) :
    ViewModel(), LifecycleObserver {
    private val repository: Repository = RepositoryImpl()
    private val lifeCycleLiveData = MutableLiveData<String>()

    lateinit var stringsInteractor: StringsInteractor

//    fun getFilm()= getDataFromLocalSource()

    fun getLiveData() = liveDataToObserve

    fun getFilmsFromLocalStorage() = getDataFromLocalSource()

//    fun getWeatherFromRemoteSource() = getDataFromLocalSource()

    fun getData(): LiveData<AppState> {
        getFilmsFromLocalStorage()
        return liveDataToObserve
    }

    fun getLifeCycleData() = lifeCycleLiveData

    private fun getDataFromLocalSource(){
        liveDataToObserve.value = AppState.Loading
        Thread{
            sleep(1000)
            liveDataToObserve.postValue(AppState.Success(
                repository.getFilmsFromLocalStorage()))
        }.start()
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun onViewStart() {
        lifeCycleLiveData.value = stringsInteractor.startStr
    }


 }