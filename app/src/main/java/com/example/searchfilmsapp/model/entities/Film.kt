package com.example.searchfilmsapp.model.entities

import android.os.Parcelable
import com.example.searchfilmsapp.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Film(
    val categories: Categories = getDefaultCategories(),
    val image: Int = R.drawable.film_vdova,
    val name: String = "Some text",
    val date: Int = 2020,
    val description : String = "Bla-bla"
): Parcelable

fun getDefaultCategories() = Categories("demoText")

fun getHardCodeFilms(): List<Film> {
    return listOf(
            Film(Categories("Horror"), R.drawable.film_vdova,
                " Vdova", 2020, "bala-bla-bla"),
            Film(Categories("Comedy"), R.drawable.callcenter,
                " Callcenter", 2020, "bala-bla-bla"),
            Film(Categories("Dram"), R.drawable.claustrofob,
                " Claystrofob", 2020, "bala-bla-bla"),
            Film(Categories("Indy"), R.drawable.hishnie_ptici,
                "Hishnie ptici", 2020, "bala-bla-bla"),
            Film(Categories("Fantasy"), R.drawable.hodyachiy_zamok,
                "Hodyachiy_zamok", 2020,"bala-bla-bla"),
            Film(Categories("Action"), R.drawable.jumanji,
                "Jumanji", 2020, "bala-bla-bla"),
            Film(Categories("Thriller"), R.drawable.pobeg,
                "Pobeg", 2020, "bala-bla-bla"),
            Film(Categories("Animation"), R.drawable.raia,
                "Raia", 2020,"bala-bla-bla")
    )
}


