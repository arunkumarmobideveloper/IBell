package com.task.ibell_lib_sdk.error_handling

/*
* Stores the state of the Apollo initial,request,response states
* */
sealed class GraphQLState {
    object Loading : GraphQLState()
    data class Success(val response: Any) : GraphQLState()
    data class Error(val message: String) : GraphQLState()
}