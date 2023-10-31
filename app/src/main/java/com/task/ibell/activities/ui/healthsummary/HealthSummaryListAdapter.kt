package com.task.ibell.activities.ui.labs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.task.ibell.R
import com.task.ibell.data.model.HealthSummaryListItems
import com.task.ibell.databinding.HealthSummaryItemsViewBinding

/*
*Display the Health Summary List in RecyclerView
* */
class HealthSummaryListAdapter(private val launches: List<HealthSummaryListItems>) :
    RecyclerView.Adapter<HealthSummaryListAdapter.ViewHolder>() {

    class ViewHolder(val binding: HealthSummaryItemsViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HealthSummaryItemsViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return launches.size
    }

    var onEndOfListReached: (() -> Unit)? = null
    var onItemClicked: ((HealthSummaryListItems) -> Unit)? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val launch = launches[position]
        holder.binding.itemText.text = launch.health_summary_type?: ""
        holder.binding.itemLogo.load(launch.health_summary_type_logo) {
            placeholder(R.drawable.baseline_person_24)
        }
        holder.binding.itemDetailsLogo.load(launch.health_summary_details_logo) {
            placeholder(R.drawable.baseline_keyboard_arrow_right_24)
        }

        if (position == launches.size - 1) {
            onEndOfListReached?.invoke()
        }

        holder.binding.root.setOnClickListener {
            onItemClicked?.invoke(launch)
        }
    }
}
