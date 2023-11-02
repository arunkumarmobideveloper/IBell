package com.task.ibell.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.ibell.data.model.DataConnectionsClinicsList
import com.task.ibell.data.model.DataConnectionsClinicsListItems
import com.task.ibell.data.model.SuggestedDataConnectionsCategoriesList
import com.task.ibell.data.model.SuggestedDataConnectionsList
import com.task.ibell.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DataConnectionsViewModel(private val repository: Repository?) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO){
            repository?.getDataConnectionsList()
        }

        viewModelScope.launch(Dispatchers.IO){
            repository?.getDataConnectionsCategoriesList()
        }

        viewModelScope.launch(Dispatchers.IO){
            repository?.getDataConnectionsClinicsList()
        }
    }

    val suggestedDataConnections : LiveData<SuggestedDataConnectionsList>
        get() = repository?.suggestedDataConnections!!

    val suggestedDataConnectionsCategories : LiveData<SuggestedDataConnectionsCategoriesList>
        get() = repository?.suggestedDataConnectionsCategories!!

    val dataConnectionsClinics : LiveData<DataConnectionsClinicsList>
        get() = repository?.dataConnectionsClinics!!

    // Add a MutableLiveData for the filtered list
    val filteredDataConnectionsClinics = MutableLiveData<List<DataConnectionsClinicsListItems>>()

    // Modify the function to filter the list based on the search query
    fun filterDataConnectionsClinics(query: String) {
        val filteredList = dataConnectionsClinics.value?.dataConnectionsClinicsList
            ?.filter { it.clinicName.contains(query, ignoreCase = true) }
        filteredDataConnectionsClinics.postValue(filteredList!!)
    }

}