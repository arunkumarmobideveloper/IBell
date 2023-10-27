package com.task.ibell.activities.ui.data_connections

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.task.ibell.BWellSampleApplication
import com.task.ibell.data.model.DataConnectionListItems
import com.task.ibell.databinding.FragmentDataConnectionsBinding
import com.task.ibell.viewmodel.DataConnectionsModelFactory
import com.task.ibell.viewmodel.DataConnectionsViewModel

class DataConnectionsFragment : Fragment() {

    private var _binding: FragmentDataConnectionsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataConnectionsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val repository = (activity?.application as? BWellSampleApplication)?.bWellRepository

        val mainViewModel = ViewModelProvider(this, DataConnectionsModelFactory(repository))[DataConnectionsViewModel::class.java]
        mainViewModel.suggestedDataConnections.observe(viewLifecycleOwner) {
            setAdapter(it.suggestedDataConnectionsList)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setAdapter(suggestedActivitiesLIst: List<DataConnectionListItems>) {
        val adapter = DataConnectionsListAdapter(suggestedActivitiesLIst)
        binding.rvSuggestedDataConnections.layoutManager = LinearLayoutManager(requireContext())
        binding.rvSuggestedDataConnections.adapter = adapter
    }
}