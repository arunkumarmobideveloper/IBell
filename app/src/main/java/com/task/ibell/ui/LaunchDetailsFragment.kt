package com.task.ibell.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs


import coil.load
import com.task.ibell.R
import com.task.ibell.databinding.LaunchDetailsFragmentBinding
import com.task.ibell_lib_sdk.apolloclient.ApolloClient
import com.task.ibell_lib_sdk.repository.User


class LaunchDetailsFragment : Fragment() {

    private lateinit var binding: LaunchDetailsFragmentBinding
    val args: LaunchDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LaunchDetailsFragmentBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenResumed {

            binding.progressBar.visibility = View.VISIBLE
            binding.error.visibility = View.GONE
            lifecycleScope.launchWhenResumed {

                binding.progressBar.visibility = View.VISIBLE
                binding.error.visibility = View.GONE



                val apolloClientMethod = ApolloClient()
                val response = apolloClientMethod.apolloClientDetailApiCall(requireActivity(),
                    args.launchId!!
                )



               /* val response = try {
                    apolloClient(requireContext()).query(LaunchDetailsQuery(id = args.launchId))
                        .execute()
                } catch (e: ApolloException) {
                    binding.progressBar.visibility = View.GONE
                    binding.error.text = "Oh no... A protocol error happened"
                    binding.error.visibility = View.VISIBLE
                    return@launchWhenResumed
                }*/

               /* val launch = response.data?.launch
                if (launch == null || response.hasErrors()) {
                    binding.progressBar.visibility = View.GONE
                    binding.error.text = response.errors?.get(0)?.message
                    binding.error.visibility = View.VISIBLE
                    return@launchWhenResumed
                }*/

               /* binding.progressBar.visibility = View.GONE

                binding.missionPatch.load(launch.mission?.missionPatch) {
                    placeholder(R.drawable.ic_placeholder)
                }
                binding.site.text = launch.site
                binding.missionName.text = launch.mission?.name
                val rocket = launch.rocket
                binding.rocketName.text = "🚀 ${rocket?.name} ${rocket?.type}"

*/
            }
        }


    }
}
