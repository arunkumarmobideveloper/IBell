package com.task.ibell_lib_sdk.apolloclient

import android.content.Context
import androidx.compose.runtime.Composable

interface ApolloClientsMethods {

    fun initApolloClient(text : String): Any
    fun apolloClientErrorMessage(error : String) :Any


}