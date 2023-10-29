package com.task.ibell.activities.ui.data_connections

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.task.ibell.R
import com.task.ibell.data.model.DataConnectionCategoriesListItems
import com.task.ibell.databinding.DataConnectionCategoriesItemsViewBinding

/*
*Display the Data Connections List in RecyclerView
* */
class DataConnectionsCategoriesListAdapter(private val launches: List<DataConnectionCategoriesListItems>) :
    RecyclerView.Adapter<DataConnectionsCategoriesListAdapter.ViewHolder>() {


    class ViewHolder(val binding: DataConnectionCategoriesItemsViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataConnectionCategoriesItemsViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return launches.size
    }

    var onEndOfListReached: (() -> Unit)? = null
    var onItemClicked: ((DataConnectionCategoriesListItems) -> Unit)? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val launch = launches[position]
        holder.binding.dataConnectionHeadingTv.text = launch.connectionCategoryName?: ""
        holder.binding.dataConnectionDescriptionIv.text = launch.description?: ""
        holder.binding.dataConnectionLogoIv.load(launch.connection_logo) {
            placeholder(R.drawable.insurance_logo)
        }

        if (position == launches.size - 1) {
            onEndOfListReached?.invoke()
        }

        holder.binding.root.setOnClickListener {
            onItemClicked?.invoke(launch)
        }
    }
}
