package com.task.ibell.activities.ui.health_journey

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.task.ibell.R

class HealthJourneyFragment : Fragment() {

    companion object {
        fun newInstance() = HealthJourneyFragment()
    }

    private lateinit var viewModel: HealthJourneyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_health_journey, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HealthJourneyViewModel::class.java)
        // TODO: Use the ViewModel
    }

}