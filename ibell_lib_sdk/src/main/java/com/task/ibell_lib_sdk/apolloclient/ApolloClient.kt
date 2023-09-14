package com.task.ibell_lib_sdk.apolloclient

class ApolloClient : ApolloClientsMethods {
    override fun initApolloClient(text: String): String {
        return "This text is from Apollo Client"
    }

    override fun apolloClientErrorMessage(error: String): Any {
        TODO("Not yet implemented")
    }
}