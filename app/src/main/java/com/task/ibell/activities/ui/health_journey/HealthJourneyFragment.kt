package com.task.ibell.activities.ui.health_journey

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.task.ibell.BWellSampleApplication
import com.task.ibell.data.model.HealthJourneyListItems
import com.task.ibell.databinding.FragmentHealthJourneyBinding
import com.task.ibell.viewmodel.HealthJourneyViewModel
import com.task.ibell.viewmodel.SharedViewModelFactory

class HealthJourneyFragment : Fragment() {

    private var _binding: FragmentHealthJourneyBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var healthJourneyViewModel: HealthJourneyViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHealthJourneyBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val repository = (activity?.application as? BWellSampleApplication)?.bWellRepository

        healthJourneyViewModel = ViewModelProvider(this, SharedViewModelFactory(repository))[HealthJourneyViewModel::class.java]

        healthJourneyViewModel.healthJourneyData.observe(viewLifecycleOwner) {
            setAdapter(it.healthJourneyList)
        }


        return root
    }

    private fun setAdapter(suggestedActivitiesLIst: List<HealthJourneyListItems>) {
        val adapter = HealthJourneyListAdapter(suggestedActivitiesLIst)
        binding.rvHealthJourney.layoutManager = LinearLayoutManager(requireContext())
        binding.rvHealthJourney.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}