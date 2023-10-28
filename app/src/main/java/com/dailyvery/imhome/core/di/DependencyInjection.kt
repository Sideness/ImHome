package com.dailyvery.imhome.core.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

object DependencyInjection {

    fun start(application: Application) {
        startKoin {
            androidContext(application)
            modules(modules)
        }
    }

}