package com.task.ibell_lib_sdk.apolloclient

import android.content.Context

interface ApolloClientsMethods {

    fun initApolloClient(text : String): Any
    fun apolloClientErrorMessage(error : String) :Any
    fun apolloClientApiCall(contaxt: Context, id: String) :Any
}