package com.example.searchfilmsapp.model

import com.example.searchfilmsapp.model.entities.Film
import com.example.searchfilmsapp.model.entities.getHardCodeFilms

class RepositoryImpl : Repository {
    override fun getFilmsFromServer() = Film()
    override fun getFilmsFromLocalStorage() = getHardCodeFilms()
}