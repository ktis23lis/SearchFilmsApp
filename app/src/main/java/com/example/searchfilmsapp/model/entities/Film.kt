package com.example.searchfilmsapp.model.entities

import android.os.Parcelable
import com.example.searchfilmsapp.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Film(
    val categories: Categories = getDefaultCategories(),
    val image: Int = R.drawable.film_vdova,
    val name: String? = "Some text",
    val date: Int? = 2020,
    val description : String? = "Bla-bla"
): Parcelable

fun getDefaultCategories() = Categories("demoText")

fun getHardCodeFilms() = listOf(
            Film(Categories("popular"), R.drawable.callcenter,
                " Callcenter", 2020, "bala-bla-bla"),
            Film(Categories("top_rated"), R.drawable.claustrofob,
                " Claystrofob", 2020, "bala-bla-bla"),
            Film(Categories("now_playing"), R.drawable.hishnie_ptici,
                "Hishnie ptici", 2020, "bala-bla-bla"),
            Film(Categories("latest"), R.drawable.hodyachiy_zamok,
                "Hodyachiy_zamok", 2020,"bala-bla-bla"),
            Film(Categories("upcoming"), R.drawable.jumanji,
                "Jumanji", 2020, "bala-bla-bla")
    )



