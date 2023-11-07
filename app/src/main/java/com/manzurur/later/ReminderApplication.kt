package com.manzurur.later

import android.app.Application
import com.airbnb.mvrx.Mavericks
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class ReminderApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        Mavericks.initialize(this)

        Timber.plant(Timber.DebugTree())
    }
}