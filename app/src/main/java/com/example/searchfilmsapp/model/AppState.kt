package com.example.searchfilmsapp.model

import com.example.searchfilmsapp.model.entities.Film

sealed class AppState{
//    data class Success(val filmsData : List<Film>) : AppState()
    data class Success(val filmsData : List<Film>) : AppState()
    data class Error (val error : Throwable) : AppState()
    object Loading : AppState()
}
