package com.example.searchfilmsapp.ui.main

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.searchfilmsapp.model.AppState
import com.example.searchfilmsapp.model.Repository
import com.example.searchfilmsapp.model.RepositoryImpl
import java.lang.Thread.sleep

class MainViewModel(
        private val liveDataToObserve: MediatorLiveData<AppState> = MediatorLiveData(),
        private val repositoryImpl: Repository = RepositoryImpl()
) :
    ViewModel() {

    fun getFilm()= getDataFromLocalSource()

    fun getLiveData() = liveDataToObserve

    fun getFilmsFromLocalStorage() = getDataFromLocalSource()

    fun getWeatherFromRemoteSource() = getDataFromLocalSource()

    private fun getDataFromLocalSource(){
        liveDataToObserve.value = AppState.Loading
        Thread{
            sleep(1000)
            liveDataToObserve.postValue(AppState.Success(repositoryImpl.getFilmsFromLocalStorage()))
        }.start()
    }



 }