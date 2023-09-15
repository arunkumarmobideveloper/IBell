package com.task.ibell.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController

import androidx.recyclerview.widget.LinearLayoutManager

import com.example.rocketreserver.LaunchListAdapter

import com.task.ibell.LaunchListQuery
import com.task.ibell.databinding.LaunchListFragmentBinding
import com.task.ibell_lib_sdk.apolloclient.ApolloClient
import kotlinx.coroutines.channels.Channel

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



        lifecycleScope.launchWhenResumed {
            var cursor: String? = null
            val apolloClientMethod = ApolloClient()
            val response = apolloClientMethod.apolloClientListApiCall(requireContext())

            if (response != null) {
                launches.addAll(response)
                adapter.notifyDataSetChanged()

            }
            adapter.onEndOfListReached = null
            channel.close()
        }


       /* adapter.onItemClicked = { launch ->
            findNavController().navigate(
               // LaunchListFragmentDirections.openLaunchDetails()

                LaunchListFragmentDirections.openLaunchDetails(lanuchID = launch.id)
            )
        }*/
    }
}
