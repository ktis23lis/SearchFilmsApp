package com.example.searchfilmsapp.strings_iteractor

import android.content.Context
import com.example.searchfilmsapp.R

class StringsInteractorImpl(private val context: Context) : StringsInteractor {
    override val errorStr = context.getString(R.string.error)
    override val startStr = context.getString(R.string.start)
}
