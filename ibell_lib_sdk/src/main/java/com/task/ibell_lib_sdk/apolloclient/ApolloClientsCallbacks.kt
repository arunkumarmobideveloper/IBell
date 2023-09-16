package com.task.ibell_lib_sdk.apolloclient

import android.content.Context
import com.apollographql.apollo3.ApolloClient
import com.task.ibell.LaunchDetailsQuery
import com.task.ibell.LaunchListQuery

interface ApolloClientsCallbacks {
    fun apolloClientInitialization(context :Context) : ApolloClient
    suspend fun apolloClientLaunchListApiCall(context: Context) : List<LaunchListQuery.Launch>?
    suspend fun apolloClientLaunchDetailApiCall(context: Context, launchId :String): LaunchDetailsQuery.Launch?
}