package com.example.searchfilmsapp.model

import com.example.searchfilmsapp.model.entities.Categories
import com.example.searchfilmsapp.model.entities.Film

interface Repository {
    fun getFilmsFromServer(categories: String) : Film
    fun getHorror() : List<Film>
    fun getDram() : List<Film>
    fun getCategoriesFromLocal() : List<Categories>
}