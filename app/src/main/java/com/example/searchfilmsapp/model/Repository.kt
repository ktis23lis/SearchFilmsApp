package com.example.searchfilmsapp.model

import com.example.searchfilmsapp.model.entities.Film

interface Repository {
    fun getFilmsFromServer() : Film
    fun getFilmsFromLocalStorage() : List<Film>
}