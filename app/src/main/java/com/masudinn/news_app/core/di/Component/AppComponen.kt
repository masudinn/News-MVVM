package com.masudinn.news_app.core.di.Component

import android.app.Application
import com.masudinn.news_app.core.Platform.BaseApplication
import com.masudinn.news_app.core.di.Modul.ActivityModule
import com.masudinn.news_app.core.di.Modul.AppModule
import com.masudinn.news_app.core.di.Modul.NetworkModule
import com.masudinn.news_app.core.di.Modul.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        NetworkModule::class,
        ViewModelModule::class
    ]
)
interface AppComponen : AndroidInjector<DaggerApplication> {

    fun inject(application: BaseApplication)

    override fun inject(instance: DaggerApplication?)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponen
    }
}