package com.task.ibell.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.ibell.data.model.LabsList
import com.task.ibell.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LabsViewModel (private val repository: Repository?) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository?.getLabsList()
        }
    }

    val labsData : LiveData<LabsList>
        get() = repository?.labs!!
}