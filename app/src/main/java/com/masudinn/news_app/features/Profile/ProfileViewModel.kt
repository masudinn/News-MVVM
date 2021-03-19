package com.masudinn.news_app.features.Profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val services : NewsService
):BaseViewModel(){
    private val profile =  MutableLiveData<Profile>()

    init {
        profile.postValue(Profile())
        fun getProfile() : LiveData<Profile> = profile
    }
}