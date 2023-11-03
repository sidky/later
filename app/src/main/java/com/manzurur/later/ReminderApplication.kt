package com.manzurur.later

import android.app.Application
import com.airbnb.mvrx.Mavericks
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ReminderApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        Mavericks.initialize(this)
    }
}