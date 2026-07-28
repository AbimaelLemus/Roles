package com.example.roles.presentation.records.remoterecords

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roles.domain.usecase.UseCases

class RemoteRecordsViewModelFactory(
    private val useCases: UseCases
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {
        return RemoteRecordsViewModel(useCases) as T
    }
}