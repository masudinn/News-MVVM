package com.masudinn.news_app.core.Platform

import dagger.android.DaggerApplication

class BaseApplication : DaggerApplication() {

    private val appComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent.inject(this)
        return appComponent
    }
}