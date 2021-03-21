package com.masudinn.news_app.core.di.Modul

import com.masudinn.news_app.core.di.ActivityScoped
import com.masudinn.news_app.features.AboutActivity
import com.masudinn.news_app.features.home.view.HomeActivity
import com.masudinn.news_app.features.profile.ProfileActivity
import com.masudinn.news_app.features.WebViewActivity
import com.masudinn.news_app.features.home.view.HomeActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ActivityScoped
    @ContributesAndroidInjector()
    abstract fun contributeAboutActivity(): AboutActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [HomeActivityModule::class])
    abstract fun contributeHomeActivity(): HomeActivity


    @ActivityScoped
    @ContributesAndroidInjector()
    abstract fun contributeProfileActivity(): ProfileActivity

    @ActivityScoped
    @ContributesAndroidInjector()
    abstract fun contributeWebViewActivity(): WebViewActivity


}