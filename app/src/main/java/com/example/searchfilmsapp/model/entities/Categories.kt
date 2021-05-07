package com.example.searchfilmsapp.model.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Categories (
    val division : String
        ) : Parcelable
