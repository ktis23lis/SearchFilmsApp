package com.example.searchfilmsapp.model.interfaces

import com.example.searchfilmsapp.model.entities.Film

interface OnItemViewClickListener {
    fun onItemViewClick(film: Film)
}