package com.example.roles.data.session

import android.content.Context
import android.content.SharedPreferences
import com.example.roles.domain.model.Role
import com.example.roles.domain.model.UserSession
import com.google.gson.Gson

object SessionManager {

    private const val PREF_NAME = "session_preferences"
    private const val KEY_SESSION = "user_session"

    private lateinit var preferences: SharedPreferences

    var currentSession: UserSession? = null
        private set

    val isSupervisor: Boolean
        get() =currentSession?.role == Role.SUPERVISOR

    fun init(context: Context) {
        preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        loadSession()
    }

    fun saveSession(session: UserSession) {
        currentSession = session
        preferences.edit().putString(KEY_SESSION, Gson().toJson(session)).apply()
    }

    fun clearSession() {
        currentSession = null
        preferences.edit().remove(KEY_SESSION).apply()
    }

    private fun loadSession() {

        val json = preferences.getString(KEY_SESSION, null)
        currentSession = json?.let {
            Gson().fromJson(it, UserSession::class.java)
        }
    }
}