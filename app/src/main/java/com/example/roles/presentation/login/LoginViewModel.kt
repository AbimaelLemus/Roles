package com.example.roles.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roles.data.repository.AuthRepositoryImpl
import com.example.roles.data.session.SessionManager
import com.example.roles.domain.usecase.LoginUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    private val loginUseCase = LoginUseCase(AuthRepositoryImpl())

    fun onUsernameChange(username: String) {
        _uiState.value = _uiState.value.copy(
            username = username
        )
    }

    fun onPasswordChange(password: String) {
        _uiState.value = _uiState.value.copy(
            password = password
        )
    }

    fun login() {

        clearError()

        val username = uiState.value.username.trim()
        val password = uiState.value.password.trim()

        if (username.isBlank() || password.isBlank()) {
            _uiState.value = _uiState.value.copy(
                error = "Usuario y contraseña son obligatorios."
            )
            return
        }

        viewModelScope.launch {

            _uiState.value = _uiState.value.copy(
                isLoading = true
            )

            val result = loginUseCase(
                username,
                password
            )

            _uiState.value = _uiState.value.copy(
                isLoading = false
            )

            result
                .onSuccess { userSession ->
                    SessionManager.currentSession = userSession
                    _uiState.value = _uiState.value.copy(
                        isLoggedIn = true
                    )
                }
                .onFailure {
                    _uiState.value = _uiState.value.copy(
                        error = it.message
                    )
                }

        }

    }

    private fun clearError() {
        _uiState.value = _uiState.value.copy(
            error = null
        )

    }
}