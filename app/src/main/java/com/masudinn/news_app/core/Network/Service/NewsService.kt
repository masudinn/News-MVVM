package com.masudinn.news_app.core.Network.Service

import com.masudinn.news_app.core.Network.Response.ArticleListResponse
import com.masudinn.news_app.core.Network.Response.SourceListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("top-headlines/")
    fun getTopHeadline(@Query("country") country: String?): Single<ArticleListResponse>

    @GET("everything")
    fun getEverything(@Query("q") query: String? = "jokowi",
                      @Query("page") page: Int? = 1): Single<ArticleListResponse>

    @GET("sources")
    fun getSources(): Single<SourceListResponse>
}