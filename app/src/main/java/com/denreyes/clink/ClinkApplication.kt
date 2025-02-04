package com.denreyes.clink

import android.app.Application
import com.denreyes.clink.di.appModules
import org.koin.core.context.startKoin

class ClinkApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModules)
        }
    }
}