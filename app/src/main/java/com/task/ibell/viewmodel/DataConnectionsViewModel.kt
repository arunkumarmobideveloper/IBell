package com.task.ibell.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.ibell.data.model.SuggestedDataConnectionsList
import com.task.ibell.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DataConnectionsViewModel(private val repository: Repository?) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO){
            repository?.getDataConnectionsList()
        }
    }

    val suggestedDataConnections : LiveData<SuggestedDataConnectionsList>
        get() = repository?.suggestedDataConnections!!
}