package com.masudinn.news_app.features.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.masudinn.news_app.core.network.Service.NewsService
import com.masudinn.news_app.core.platform.BaseViewModel
import javax.inject.Inject

class ProfileViewModel  @Inject constructor(
    private val service: NewsService
) : BaseViewModel() {

    private val profile = MutableLiveData<Profile>()

    init { profile.postValue(Profile()) }

    fun getProfile(): LiveData<Profile> = profile
}