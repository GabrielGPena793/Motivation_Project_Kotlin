package com.example.motivation.infra

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {

    private val security: SharedPreferences =
        context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)


    fun addStorageString(key: String, value: String) {
        security.edit().putString(key, value).apply()
    }

    fun getStorageString(key: String): String {
        return security.getString(key, "")  ?: ""
    }
}