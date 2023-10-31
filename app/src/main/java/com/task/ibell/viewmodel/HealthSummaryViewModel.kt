package com.task.ibell.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.ibell.data.model.HealthSummaryList
import com.task.ibell.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HealthSummaryViewModel (private val repository: Repository?) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository?.getHealthSummaryList()
        }
    }

    val healthSummaryData : LiveData<HealthSummaryList>
        get() = repository?.healthSummary!!
}