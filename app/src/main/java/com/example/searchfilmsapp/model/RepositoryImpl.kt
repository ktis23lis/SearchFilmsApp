package com.example.searchfilmsapp.model

import com.example.searchfilmsapp.model.entities.Film
import com.example.searchfilmsapp.model.entities.getHardCodeFilms
import com.example.searchfilmsapp.model.interfaces.FilmsLoader

class RepositoryImpl : Repository {
    override fun getFilmsFromServer(categories: String) : Film {
        val dto = FilmsLoader.loadFIlm(categories)
        return Film(
            name = dto?.results?.original_title,
            date = dto?.results?.release_date,
            description = dto?.results?.overview
        )
    }
    override fun getFilmsFromLocalStorage() = getHardCodeFilms()
}