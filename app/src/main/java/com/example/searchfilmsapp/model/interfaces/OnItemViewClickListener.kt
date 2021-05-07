package com.example.searchfilmsapp.model.interfaces

import android.util.Log
import android.widget.Toast
import com.example.searchfilmsapp.model.entities.Film

interface OnItemViewClickListener {
    fun onItemViewClick(film: Film)
}