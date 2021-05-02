package com.example.searchfilmsapp.model.entities

import com.example.searchfilmsapp.R

data class Film(
    val categories: Categories = getDefaultCategories(),
    val image: Int = R.drawable.film_vdova,
    val name: String = "Some text",
    val date: Int = 2020
)
fun getDefaultCategories() = Categories("Horror")

fun getHardCodeFilms(): List<Film>{
    return listOf(
            Film(Categories("Horror"),R.drawable.film_vdova, " Vdova", 2020),
            Film(Categories("Horror"),R.drawable.callcenter, " Callcenter", 2020 ),
            Film(Categories("Horror"),R.drawable.claustrofob, " Claystrofob", 2020),
            Film(Categories("Horror"),R.drawable.hishnie_ptici, "Hishnie ptici", 2020 ),
            Film(Categories("Horror"),R.drawable.hodyachiy_zamok, " Hodyachiy_zamok", 2020),
            Film(Categories("Horror"),R.drawable.jumanji, " Jumanji", 2020 ),
            Film(Categories("Horror"),R.drawable.pobeg, " Pobeg", 2020),
            Film(Categories("Horror"),R.drawable.raia, " Raia", 2020 )
    )
}



