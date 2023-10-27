package com.task.ibell

import android.app.Application
import com.task.ibell.repository.Repository

class BWellSampleApplication : Application() {

     lateinit var bWellRepository: Repository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        bWellRepository = Repository( applicationContext)
    }
}