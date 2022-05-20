package com.testing.navigationtest.presentation.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        baseInstance = this
    }

    companion object {
        lateinit var baseInstance: App
    }
}