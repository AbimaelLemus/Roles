package com.example.roles.presentation.records.remoterecords

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roles.domain.usecase.GetRemotePersonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RemoteRecordsViewModel @Inject constructor(
    private val getRemotePersons: GetRemotePersonsUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(RemoteRecordsUiState())
    val uiState: StateFlow<RemoteRecordsUiState> = _uiState.asStateFlow()

    init {

        loadPersons()

    }

    private fun loadPersons() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }
            try {
                val persons = getRemotePersons()
                _uiState.update {
                    it.copy(
                        persons = persons,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = e.message
                    )
                }
            }
        }

    }
}