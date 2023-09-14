package com.task.ibell_lib_sdk.apolloclient

interface ApolloClientsMethods {

    fun initApolloClient(text : String): Any
    fun apolloClientErrorMessage(error : String) :Any
}