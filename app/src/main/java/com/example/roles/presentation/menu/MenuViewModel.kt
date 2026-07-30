package com.example.roles.presentation.menu

import androidx.lifecycle.ViewModel
import com.example.roles.data.session.SessionManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val sessionManager: SessionManager
) : ViewModel() {
    private val _uiState = MutableStateFlow(
        MenuUiState(
            role = sessionManager.currentSession?.role,
            username = sessionManager.currentSession?.username.orEmpty()
        )
    )
    val uiState = _uiState.asStateFlow()

    fun logout() {
        sessionManager.clearSession()
    }
}