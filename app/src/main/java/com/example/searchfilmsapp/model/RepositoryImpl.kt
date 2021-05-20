package com.example.searchfilmsapp.model

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.searchfilmsapp.model.entities.*

class RepositoryImpl : Repository {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun getFilmsFromServer(categories: String) = Film()
//        val dto = FilmsLoader.loadFIlm(categories)

//        return Film(
//            name = dto?.original_title,
//            date = dto?.release_date,
//            description = dto?.overview
//        )

    override fun getHorror() = getHardCodeHorror()
    override fun getDram() = getHardCodeDram()
//    override fun getComedy() = getHardCodeComedy()
    override fun getCategoriesFromLocal() = getHardCategories()


}