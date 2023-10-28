package com.dailyvery.imhome

import android.app.Application
import com.dailyvery.imhome.core.di.DependencyInjection

class ImHomeApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        DependencyInjection.start(this)
    }
    
}