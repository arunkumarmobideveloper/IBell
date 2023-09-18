package com.task.ibell_lib_sdk

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional
import com.apollographql.apollo3.network.okHttpClient
import com.task.ibell.LaunchDetailsQuery
import com.task.ibell.LaunchListQuery
import com.task.ibell_lib_sdk.Utils.Constants.BASE_URL
import com.task.ibell_lib_sdk.Utils.Constants.HTTPS
import com.task.ibell_lib_sdk.Utils.Constants.MOCK_DATA_JUNIT_TEST_CASE
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


class ApolloClientConfigurationInstrumentedTest  {
    private lateinit var apolloClient: ApolloClient

    @Before
    fun setupApolloClientTest() {
        val okHttpClient = OkHttpClient.Builder()
            .build()
        apolloClient = ApolloClient.Builder()
            .serverUrl(HTTPS + BASE_URL)
            .okHttpClient(okHttpClient)
            .build()
    }
    @Test
    fun launchListTestGraphQLQuery() = runBlocking {
        val response =
            apolloClient.query(LaunchListQuery(Optional.Present("")))
                .execute()
        val launch = response.data?.launches?.launches
        assertEquals(launch?.get(0).toString(),  MOCK_DATA_JUNIT_TEST_CASE)
        assertEquals(launch?.get(1).toString(),  MOCK_DATA_JUNIT_TEST_CASE)
    }
    @Test
    fun launchDetailTestGraphQLQuery() = runBlocking {
        val response = apolloClient.query(LaunchDetailsQuery("110"))
            .execute()
        val launchDetail = response.data?.launch
        assertEquals(launchDetail,  110)
        assertEquals(launchDetail,  114)
    }
}