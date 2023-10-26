package com.task.ibell.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.task.ibell.R
import com.task.ibell.data.model.UserData
import com.task.ibell.ui.viewmodel.UserDataViewModel
import com.task.ibell.ui.viewmodel.UserDataViewModelFactory
import kotlinx.android.synthetic.main.your_fragment_layout.*

class ViewProfileFragment : Fragment(R.layout.fragment_view_profile) {

    private lateinit var viewModel: UserDataViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences = requireActivity().getSharedPreferences("your_prefs_name", Context.MODE_PRIVATE)
        viewModel = ViewModelProvider(this, UserDataViewModelFactory(sharedPreferences)).get(UserDataViewModel::class.java)

        viewModel.userData.observe(viewLifecycleOwner) { userData ->
            updateUI(userData)
        }

        viewModel.fetchData()
    }

    private fun updateUI(userData: UserData) {
        /*firstNameEditText.setText(userData.firstName)
        lastNameEditText.setText(userData.lastName)*/
        // Update other UI elements...
    }
}
