package com.task.ibell

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


import com.task.ibell.databinding.ActivityMainBinding
import com.task.ibell_lib_sdk.apolloclient.ApolloClient


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

         val apolloClientMethod = ApolloClient()
        apolloClientMethod.initApolloClient("text implementation")





    }
}