package com.task.ibell.activities.ui.data_connections

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.task.ibell.BWellSampleApplication
import com.task.ibell.R
import com.task.ibell.data.model.DataConnectionCategoriesListItems
import com.task.ibell.data.model.DataConnectionListItems
import com.task.ibell.databinding.FragmentDataConnectionsParentBinding
import com.task.ibell.viewmodel.DataConnectionsViewModel
import com.task.ibell.viewmodel.SharedViewModelFactory

class DataConnectionsFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentDataConnectionsParentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var dataConnectionsViewModel: DataConnectionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataConnectionsParentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val repository = (activity?.application as? BWellSampleApplication)?.bWellRepository

        dataConnectionsViewModel = ViewModelProvider(this, SharedViewModelFactory(repository))[DataConnectionsViewModel::class.java]


        binding.includeHomeView.header.setText(resources.getString(R.string.connect_health_records))
        binding.includeHomeView.subText.setText(resources.getString(R.string.connect_health_records_sub_txt))
        binding.includeHomeView.btnGetStarted.setText(resources.getString(R.string.lets_go))
        binding.includeHomeView.btnGetStarted.setOnClickListener(this)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setDataConnectionsAdapter(suggestedActivitiesLIst: List<DataConnectionListItems>) {
        val adapter = DataConnectionsListAdapter(suggestedActivitiesLIst)
        binding.includeDataConnections.dataConnectionFragment.visibility = View.VISIBLE;
        binding.includeDataConnectionCategory.dataConnectionFragment.visibility = View.GONE;
        binding.includeDataConnections.rvSuggestedDataConnections.layoutManager = LinearLayoutManager(requireContext())
        binding.includeDataConnections.rvSuggestedDataConnections.adapter = adapter
    }

    private fun setDataConnectionsCategoryAdapter(suggestedActivitiesLIst: List<DataConnectionCategoriesListItems>) {
        val adapter = DataConnectionsCategoriesListAdapter(suggestedActivitiesLIst)
        adapter.onItemClicked = { selectedDataConnection ->
            // Handle item click, perform UI changes here
            displayRelatedDataConnectionsList();
        }
        binding.includeDataConnectionCategory.dataConnectionFragment.visibility = View.VISIBLE;
        binding.includeDataConnections.dataConnectionFragment.visibility = View.GONE;
        binding.includeDataConnectionCategory.rvSuggestedDataConnections.layoutManager = LinearLayoutManager(requireContext())
        binding.includeDataConnectionCategory.rvSuggestedDataConnections.adapter = adapter
    }

    private fun displayRelatedDataConnectionsList() {
        dataConnectionsViewModel.suggestedDataConnections.observe(viewLifecycleOwner) {
            setDataConnectionsAdapter(it.suggestedDataConnectionsList)
        }
    }

    override fun onClick(p0: View?) {
        when (view?.id) {
            R.id.btn_get_started -> {
                binding.includeDataConnectionCategory.dataConnectionFragment.visibility = View.VISIBLE;
                binding.includeHomeView.headerView.visibility = View.GONE;
                dataConnectionsViewModel.suggestedDataConnectionsCategories.observe(viewLifecycleOwner) {
                    setDataConnectionsCategoryAdapter(it.suggestedDataConnectionsCategoriesList)
                }
            }
        }
    }
}