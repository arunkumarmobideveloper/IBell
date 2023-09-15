package com.task.ibell_lib_sdk.apolloclient

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.api.Optional


import com.apollographql.apollo3.exception.ApolloException

import com.task.ibell.LaunchDetailsQuery
import com.task.ibell.LaunchListQuery

class ApolloClient : ApolloClientsMethods {
    override fun initApolloClient(text: String): String {
        return "This text is from Apollo Client"
    }

    override fun apolloClientErrorMessage(error: String): Any {
        TODO("Not yet implemented")
    }

    /*this is for list*/
    suspend fun apolloClientListApiCall(contaxt: Context): List<LaunchListQuery.Launch>? {

        try {
            val response = apolloClient(contaxt).query(LaunchListQuery(Optional.Present(""))).execute()

            Log.d("TAG", "apolloClientApiCall: "+response.data)
            val newLaunches = response.data?.launches?.launches?.filterNotNull()
            return newLaunches


        } catch (e: ApolloException) {


        }
        return null
    }

    /*this is for list Details*/

    suspend fun apolloClientDetailApiCall(contaxt: Context,launchId: String): LaunchDetailsQuery.Launch? {

        try {

            val response =  apolloClient(contaxt).query(LaunchDetailsQuery(launchId))
                .execute()

            Log.d("TAG", "apolloClientDetailsApiCall: "+response.data)

            val newLaunches = response.data?.launch

            return newLaunches


        } catch (e: ApolloException) {


        }
        return null
    }



}