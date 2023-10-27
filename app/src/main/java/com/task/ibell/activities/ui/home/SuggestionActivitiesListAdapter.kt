package com.task.ibell.activities.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load

import com.task.ibell.R
import com.task.ibell.data.model.ActivityListItems
import com.task.ibell.databinding.LaunchItemBinding

/*
*Display the Launches List in RecyclerView
*@argument : launches: List<LaunchListQuery.Launch>
* */
class SuggestionActivitiesListAdapter(private val launches: List<ActivityListItems>) :
    RecyclerView.Adapter<SuggestionActivitiesListAdapter.ViewHolder>() {

    class ViewHolder(val binding: LaunchItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LaunchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return launches.size
    }

    var onEndOfListReached: (() -> Unit)? = null
    var onItemClicked: ((ActivityListItems) -> Unit)? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val launch = launches[position]
        holder.binding.header.text = launch.headerText?: ""
        holder.binding.subText.text = launch.subText
        holder.binding.icon.load(launch.icon) {
            placeholder(R.drawable.vaccine_icon)
        }

        if (position == launches.size - 1) {
            onEndOfListReached?.invoke()
        }

        holder.binding.root.setOnClickListener {
            onItemClicked?.invoke(launch)
        }
    }
}
