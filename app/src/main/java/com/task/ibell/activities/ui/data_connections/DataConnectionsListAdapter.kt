package com.task.ibell.activities.ui.data_connections

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.task.ibell.R
import com.task.ibell.data.model.DataConnectionListItems
import com.task.ibell.databinding.DataConnectionsItemsViewBinding

/*
*Display the Data Connections List in RecyclerView
* */
class DataConnectionsListAdapter(private val launches: List<DataConnectionListItems>) :
    RecyclerView.Adapter<DataConnectionsListAdapter.ViewHolder>() {

    class ViewHolder(val binding: DataConnectionsItemsViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataConnectionsItemsViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return launches.size
    }

    var onEndOfListReached: (() -> Unit)? = null
    var onItemClicked: ((DataConnectionListItems) -> Unit)? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val launch = launches[position]
        holder.binding.header.text = launch.connectionName?: ""
        holder.binding.textViewStatus.text = launch.status?: ""
        holder.binding.changeStatusIv.load(launch.status_change_logo) {
            placeholder(R.drawable.insurance_logo)
        }
        holder.binding.icon.load(launch.connection_logo) {
            placeholder(R.drawable.baseline_person_pin_24)
        }

        if (position == launches.size - 1) {
            onEndOfListReached?.invoke()
        }

        holder.binding.root.setOnClickListener {
            onItemClicked?.invoke(launch)
        }
    }
}
