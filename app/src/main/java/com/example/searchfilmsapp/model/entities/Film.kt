package com.example.searchfilmsapp.model.entities

import android.os.Parcelable
import com.example.searchfilmsapp.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Film(
    val categories: Categories = getDefaultCategories(),
    val image: Int = R.drawable.film_vdova,
    val name: String? = "Some text",
    val date: String? = "202",
    val description : String? = "Bla-bla"
): Parcelable

fun getDefaultCategories() = Categories("demoText")

fun getHardCodeHorror() : Array<Film> {
    return arrayOf (
       ( Film(Categories("Horror"), R.drawable.callcenter,
                " Callcenter", "2020", "bala-bla-bla")),
       ( Film(Categories("Horror"), R.drawable.claustrofob,
                " Claystrofob", "2020", "bala-bla-bla")),
        (Film(Categories("Horror"), R.drawable.pobeg,
                " Pobeg", "2020", "bala-bla-bla")),
        (Film(Categories("Horror"), R.drawable.hodyachiy_zamok,
                " Claystrofob", "2020", "bala-bla-bla"))
    )
}

fun getHardCodeDram() : Array<Film> {
    return arrayOf (
        (Film(Categories("Dram"), R.drawable.raia,
                " Raia", "2020", "bala-bla-bla")),
        (Film(Categories("Dram"), R.drawable.jumanji,
                " Jumanji", "2020", "bala-bla-bla")),
        (Film(Categories("Dram"), R.drawable.dom_monstrov,
                " Dom Monstrov", "2020", "bala-bla-bla")),
        (Film(Categories("Horror"), R.drawable.film_vdova,
                " Callcenter", "2020", "bala-bla-bla")),
    )
}





