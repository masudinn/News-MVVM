package com.masudinn.news_app.core.di.Modul

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.masudinn.news_app.core.Utils.ViewModelFactory
import com.masudinn.news_app.core.di.ViewModelKey
import com.masudinn.news_app.features.home.viewmodel.HomeViewModel
import com.masudinn.news_app.features.profile.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun homeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    internal abstract fun profileViewModel(viewModel: ProfileViewModel): ViewModel
}