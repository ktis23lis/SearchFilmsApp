package com.example.searchfilmsapp.model

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.searchfilmsapp.model.entities.*

class RepositoryImpl : Repository {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun getFilmsFromServer(categories: String) = Film()
    override fun getHorror() = getHardCodeHorror()
    override fun getDram() = getHardCodeDram()
    override fun getCategoriesFromLocal() = getHardCategories()


}