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
import com.task.ibell_lib_sdk.error_handling.GraphQLState
import okhttp3.OkHttpClient

class ApolloClientConfiguration : ApolloClientsCallbacks {
    private var instance: ApolloClient? = null

    /*
    * Apollo Client initialization by extending ApolloClient SDK class
    * @Argument : Context
    * */
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

    /*
    * This method fetch all Launches List from the api through LaunchListQuery added in #graphql->graphql_schema folder
    * @Argument : Context
    * @Type : List<LaunchListQuery.Launch>
    * */
    override suspend fun apolloClientLaunchListApiCall(context: Context): List<LaunchListQuery.Launch>? {
        try {
            val response =
                apolloClientInitialization(context).query(LaunchListQuery(Optional.Present("")))
                    .execute()
            Log.d("TAG", "apolloClientApiCall: " + response.data)

            val launch = response.data?.launches?.launches
            if (launch == null || response.hasErrors()) {
                //Error state can be fetched through Observer/Flow in User Interface to make event driven approach-TODO: [Further enhancement]
                GraphQLState.Error(response.errors?.get(0)!!.message)
                return null
            }
            //Success state can be fetched through Observer/Flow in User Interface to update asynchronously -TODO: [Further enhancement]
            GraphQLState.Success(response)
            return launch.filterNotNull()
        } catch (_: ApolloException) {
        }
        return null
    }
    /*
     * This method fetch the detail of a particular launches from the list from the api through LaunchDetailQuery added in #graphql->graphql_schema folder
     * @Arguments : Context,LaunchID
     * */
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