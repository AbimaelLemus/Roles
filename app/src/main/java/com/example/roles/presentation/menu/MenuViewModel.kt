package com.example.roles.presentation.menu

import androidx.lifecycle.ViewModel
import com.example.roles.data.session.SessionManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MenuViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MenuUiState(
        role = SessionManager.currentSession?.role
    ))
    val uiState = _uiState.asStateFlow()
}