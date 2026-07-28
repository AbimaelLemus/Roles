package com.example.roles.presentation.records.addrecord

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roles.domain.usecase.UseCases

class AddRecordViewModelFactory(
    private val useCases: UseCases
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {
        if (modelClass.isAssignableFrom(AddRecordViewModel::class.java)) {
            return AddRecordViewModel(
                useCases
            ) as T
        }
        throw IllegalArgumentException(
            "Unknown ViewModel class"
        )
    }
}