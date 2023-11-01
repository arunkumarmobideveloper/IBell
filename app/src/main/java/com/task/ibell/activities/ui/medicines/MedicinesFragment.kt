package com.task.ibell.activities.ui.medicines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.task.ibell.BWellSampleApplication
import com.task.ibell.activities.ui.data_connections.DataConnectionsCategoriesListAdapter
import com.task.ibell.data.model.DataConnectionCategoriesListItems
import com.task.ibell.databinding.FragmentMedicinesBinding
import com.task.ibell.viewmodel.MedicinesViewModel
import com.task.ibell.viewmodel.SharedViewModelFactory

class MedicinesFragment : Fragment() {

    private var _binding: FragmentMedicinesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var medicinesViewModel: MedicinesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMedicinesBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val repository = (activity?.application as? BWellSampleApplication)?.bWellRepository

        medicinesViewModel = ViewModelProvider(this, SharedViewModelFactory(repository))[MedicinesViewModel::class.java]

        medicinesViewModel.suggestedDataConnectionsCategories.observe(viewLifecycleOwner) {
            setAdapter(it.suggestedDataConnectionsCategoriesList)
        }
        return root
    }

    private fun setAdapter(suggestedActivitiesLIst: List<DataConnectionCategoriesListItems>) {
        val adapter = DataConnectionsCategoriesListAdapter(suggestedActivitiesLIst)
        binding.rvSuggestedDataConnections.layoutManager = LinearLayoutManager(requireContext())
        binding.rvSuggestedDataConnections.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}