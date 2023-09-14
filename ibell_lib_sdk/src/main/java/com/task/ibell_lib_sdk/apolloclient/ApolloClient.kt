package com.task.ibell_lib_sdk.apolloclient

import android.content.Context
import android.view.View

import com.apollographql.apollo3.exception.ApolloException
import com.task.ibell.LaunchDetailsQuery

class ApolloClient : ApolloClientsMethods {
    override fun initApolloClient(text: String): String {
        return "This text is from Apollo Client"
    }

    override fun apolloClientErrorMessage(error: String): Any {
        TODO("Not yet implemented")
    }

    override  fun apolloClientApiCall(contaxt: Context, id: String): Any {
       /* val response = try {
            apolloClient(contaxt).query(LaunchDetailsQuery(id))
                .execute()
        } catch (e: ApolloException) {


        }
        return response*/
        return TODO("Provide the return value")
    }
}