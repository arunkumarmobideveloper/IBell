package com.task.ibell.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.task.ibell.repository.Repository

class SharedViewModelFactory(private val repository: Repository?) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(SharedViewModel::class.java) -> {
                SharedViewModel(repository) as T
            }
            modelClass.isAssignableFrom(DataConnectionsViewModel::class.java) -> {
                DataConnectionsViewModel(repository) as T
            }
            modelClass.isAssignableFrom(HealthSummaryViewModel::class.java) -> {
                HealthSummaryViewModel(repository) as T
            }
            modelClass.isAssignableFrom(LabsViewModel::class.java) -> {
                LabsViewModel(repository) as T
            }
            modelClass.isAssignableFrom(MedicinesViewModel::class.java) -> {
                MedicinesViewModel(repository) as T
            }
            modelClass.isAssignableFrom(HealthJourneyViewModel::class.java) -> {
                HealthJourneyViewModel(repository) as T
            }
            // Add more ViewModel classes as needed
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}