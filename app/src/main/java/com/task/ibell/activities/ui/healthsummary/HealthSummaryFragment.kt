package com.task.ibell.activities.ui.healthsummary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.task.ibell.BWellSampleApplication
import com.task.ibell.activities.ui.labs.HealthSummaryListAdapter
import com.task.ibell.data.model.HealthSummaryListItems
import com.task.ibell.databinding.FragmentHealthSummaryBinding
import com.task.ibell.viewmodel.HealthSummaryViewModel
import com.task.ibell.viewmodel.SharedViewModelFactory

class HealthSummaryFragment : Fragment() {

    private var _binding: FragmentHealthSummaryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var healthSummaryViewModel: HealthSummaryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHealthSummaryBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val repository = (activity?.application as? BWellSampleApplication)?.bWellRepository

        healthSummaryViewModel = ViewModelProvider(this, SharedViewModelFactory(repository))[HealthSummaryViewModel::class.java]

        healthSummaryViewModel.healthSummaryData.observe(viewLifecycleOwner) {
            setHealthSummaryAdapter(it.healthSummaryList)
        }


        return root
    }

    private fun setHealthSummaryAdapter(suggestedActivitiesLIst: List<HealthSummaryListItems>) {
        val adapter = HealthSummaryListAdapter(suggestedActivitiesLIst)
        binding.rvHealthSummary.layoutManager = LinearLayoutManager(requireContext())
        binding.rvHealthSummary.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}