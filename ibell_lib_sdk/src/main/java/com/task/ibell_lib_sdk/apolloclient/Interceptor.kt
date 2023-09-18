package com.task.ibell_lib_sdk.apolloclient

import android.content.Context
import com.task.ibell_lib_sdk.Utils.Constants.AUTHORIZATION
import com.task.ibell_lib_sdk.repository.User
import okhttp3.Interceptor
import okhttp3.Response

/*
* Apollo Client request Interceptor for Graphql query authentication
* */
 class AuthorizationInterceptor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader(AUTHORIZATION, User.getToken(context) ?: "")
            .build()
        return chain.proceed(request)
    }
}
