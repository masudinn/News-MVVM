package com.masudinn.news_app.core.Data

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.masudinn.news_app.core.Network.Service.NewsService
import javax.inject.Inject

class ArticleDataSourceFactory @Inject constructor(private val service: NewsService): DataSource.Factory<Int, Articles>() {

    private val dataSourceLiveData = MutableLiveData<ArticlesDataSource>()

    override fun create(): DataSource<Int, Articles> {
        val dataSource = ArticlesDataSource(service)
        dataSourceLiveData.postValue(dataSource)
        return dataSource
    }

}