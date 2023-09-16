package com.task.ibell_lib_sdk.apolloclient

import android.content.Context
import android.util.Log
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional


import com.apollographql.apollo3.exception.ApolloException
import com.apollographql.apollo3.network.okHttpClient

import com.task.ibell.LaunchDetailsQuery
import com.task.ibell.LaunchListQuery
import com.task.ibell_lib_sdk.Utils.Constants.BASE_URL
import com.task.ibell_lib_sdk.Utils.Constants.HTTPS
import com.task.ibell_lib_sdk.Utils.Constants.WEB_SOCKET_URL
import okhttp3.OkHttpClient

class ApolloClientConfiguration : ApolloClientsCallbacks {
    private var instance: ApolloClient? = null
    override fun apolloClientInitialization(mContext: Context): ApolloClient {
        if (instance != null) {
            return instance as ApolloClient
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(AuthorizationInterceptor(mContext))
            .build()

        instance = ApolloClient.Builder()
            .serverUrl(HTTPS + BASE_URL)
            .webSocketServerUrl(WEB_SOCKET_URL + BASE_URL)
            .okHttpClient(okHttpClient)
            .build()
        return instance!!
    }

    override suspend fun apolloClientLaunchListApiCall(context: Context): List<LaunchListQuery.Launch>? {
        try {
            val response =
                apolloClientInitialization(context).query(LaunchListQuery(Optional.Present("")))
                    .execute()
            Log.d("TAG", "apolloClientApiCall: " + response.data)
            return response.data?.launches?.launches?.filterNotNull()
        } catch (_: ApolloException) {
        }
        return null
    }

    override suspend fun apolloClientLaunchDetailApiCall(
        context: Context,
        launchId: String
    ): LaunchDetailsQuery.Launch? {
        try {
            val response = apolloClientInitialization(context).query(LaunchDetailsQuery(launchId))
                .execute()
            Log.d("TAG", "apolloClientDetailsApiCall: " + response.data)
            return response.data?.launch
        } catch (_: ApolloException) {
        }
        return null
    }
}