package com.task.ibell.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.task.ibell.repository.Repository

class DataConnectionsModelFactory(private val repository: Repository?) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DataConnectionsViewModel(repository) as T
    }
}