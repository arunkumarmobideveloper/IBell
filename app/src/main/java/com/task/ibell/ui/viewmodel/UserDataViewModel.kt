package com.task.ibell.ui.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.task.ibell.data.model.UserData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserDataViewModel(private val sharedPreferences: SharedPreferences) : ViewModel() {

    private val _userData = MutableLiveData<UserData>()
    val userData: LiveData<UserData>
        get() = _userData

    fun fetchData() {
        viewModelScope.launch {
            try {
                val data = withContext(Dispatchers.IO) {
                    // get UserData as string from shared object
                    val userDataString = sharedPreferences.getString("key", "")
                    // Convert the stored string back to UserData
                    Gson().fromJson(userDataString, UserData::class.java)
                }
                _userData.postValue(data)
            } catch (e: Exception) {
                // Handle errors
            }
        }
    }
}

