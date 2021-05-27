package com.example.searchfilmsapp.model

import com.example.searchfilmsapp.model.entities.Categories
import com.example.searchfilmsapp.model.entities.Film

sealed class AppState{

    data class Success(val categoriesData : List<Categories>) : AppState()
    data class Error (val error : Throwable) : AppState()
    object Loading : AppState()
}
