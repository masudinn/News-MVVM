package com.masudinn.news_app.core.platform

import com.masudinn.news_app.core.di.Component.DaggerAppComponen
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BaseApplication : DaggerApplication() {

    private val appComponent by lazy {
        DaggerAppComponen.builder()
            .application(this)
            .build()
    }


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent.inject(this)
        return appComponent
    }
}