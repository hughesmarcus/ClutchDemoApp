package com.projects.harbor.clutchdemoapp

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color

class Prefs (context: Context) {
    val BACKGROUND = "background_color"
    val prefs: SharedPreferences = context.getSharedPreferences("com.projects.harbor.prefs", 0)

    var bgColor: Int
        set(index) = prefs.edit().putInt(BACKGROUND, index).apply()
        get() = prefs.getInt(BACKGROUND, 0)
}