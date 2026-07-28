package com.example.roles.presentation.records.localrecords

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roles.domain.usecase.UseCases

class LocalRecordsViewModelFactory(
    private val useCases: UseCases
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {
        if (modelClass.isAssignableFrom(LocalRecordsViewModel::class.java)) {
            return LocalRecordsViewModel(
                useCases
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}