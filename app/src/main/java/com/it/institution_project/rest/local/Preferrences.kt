package com.it.institution_project.rest.local

import android.content.Context
import android.content.SharedPreferences


class Preferrences(private var context: Context) {

    companion object {

        const val FILENAME = "app_project"
        const val TOKEN = "token"
        const val INS_ID = "ins_id"
        const val INS_DISTRICT = "ins_district"
        const val INS_LOCALITY = "ins_locality"

    }

    fun getToken(): String {
        return getString(TOKEN) ?: ""
    }

    fun getInsId(): String? {
        return getString(INS_ID)
    }
    fun getInsDistrict(): String? {
        return getString(INS_DISTRICT)
    }
    fun getInsLocality(): String? {
        return getString(INS_LOCALITY)
    }


    private fun getString(key: String): String? {
        return getShareadPreferrneces().getString(key, null)
    }

    private fun getInt(key: String): Int? {
        return getShareadPreferrneces().getInt(key, 0)
    }

    fun cleardatalogout() {
        saveString(TOKEN, "")
    }

    internal fun clear() {
        getShareadPreferrneces().edit().clear().apply()
    }

    fun saveToken(token: String) {
        saveString(TOKEN, token)
    }

    fun saveUserId(ins_id: String) {
        saveString(INS_ID, ins_id)
    }

    fun saveLocality(Locality: String) {
        saveString(INS_LOCALITY, Locality)
    }


    private fun saveString(key: String, value: String) {
        val editor = getShareadPreferrneces().edit()
        editor.putString(key, value)
        editor.apply()
    }

    private fun saveInt(key: String, value: Int) {
        val editor = getShareadPreferrneces().edit()
        editor.putInt(key, value)
        editor.apply()
    }

    private fun getShareadPreferrneces(): SharedPreferences {

        return context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE)

    }

}