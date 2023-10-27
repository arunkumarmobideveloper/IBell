package com.task.ibell.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope

import androidx.recyclerview.widget.LinearLayoutManager

import com.task.ibell.LaunchListQuery
import com.task.ibell.databinding.LaunchListFragmentBinding
import com.task.ibell_lib_sdk.apolloclient.ApolloClientConfiguration
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

class LaunchListFragment : Fragment() {
    private lateinit var binding: LaunchListFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LaunchListFragmentBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val launches = mutableListOf<LaunchListQuery.Launch>()
        val adapter = LaunchListAdapter(launches)
        binding.launches.layoutManager = LinearLayoutManager(requireContext())
        binding.launches.adapter = adapter

        val channel = Channel<Unit>(Channel.CONFLATED)

        // Send a first item to do the initial load else the list will stay empty forever
        channel.trySend(Unit)
        adapter.onEndOfListReached = {
            channel.trySend(Unit)
        }



        lifecycleScope.launch {
            ApolloClientConfiguration().apolloClientInitialization(requireContext())
            val response = ApolloClientConfiguration().apolloClientLaunchListApiCall(requireContext())
            if (response != null) {
                launches.addAll(response)
                adapter.notifyDataSetChanged()
            }
            adapter.onEndOfListReached = null
            channel.close()
        }
    }
}
