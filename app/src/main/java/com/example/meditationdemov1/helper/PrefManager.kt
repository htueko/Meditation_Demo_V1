package com.example.meditationdemov1.helper

import android.content.Context
import android.content.SharedPreferences


class PrefManager(context: Context) {

    companion object {
        // Shared preferences file name
        private const val PREF_NAME = "meditation version one"
        private const val IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch"
        private const val PRIVATE_MODE = 0
    }

    private var pref: SharedPreferences
    private var editor: SharedPreferences.Editor

    init {
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }

    var isFirstTimeLaunch: Boolean
        get() = pref.getBoolean(IS_FIRST_TIME_LAUNCH, true)
        set(isFirstTime) {
            editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime)
            editor.commit()
        }

}