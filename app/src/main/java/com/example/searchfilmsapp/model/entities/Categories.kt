package com.example.searchfilmsapp.model.entities

import android.os.Parcelable
import com.example.searchfilmsapp.model.Repository
import com.example.searchfilmsapp.model.RepositoryImpl
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Categories (
    val division : String,
        ) : Parcelable

fun getHardCategories() = listOf(
        Categories("Horror"),
        Categories("Dram"),
//        Categories("Comedy")

)
