package com.task.ibell.activities.ui.labs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task.ibell.data.model.LabsListItems
import com.task.ibell.databinding.LabsItemsViewBinding

/*
*Display the Labs List in RecyclerView
* */
class LabsListAdapter(private val launches: List<LabsListItems>) :
    RecyclerView.Adapter<LabsListAdapter.ViewHolder>() {

    class ViewHolder(val binding: LabsItemsViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LabsItemsViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return launches.size
    }

    var onEndOfListReached: (() -> Unit)? = null
    var onItemClicked: ((LabsListItems) -> Unit)? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val launch = launches[position]
        holder.binding.header.text = launch.labsType?: ""
        holder.binding.textViewDate.text = launch.labsDate?: ""
        holder.binding.textViewStatus.text = launch.labsStatus?: ""

        if (position == launches.size - 1) {
            onEndOfListReached?.invoke()
        }

        holder.binding.root.setOnClickListener {
            onItemClicked?.invoke(launch)
        }
    }
}
