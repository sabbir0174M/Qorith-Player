package com.qorithone.qorith

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class QorithApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
