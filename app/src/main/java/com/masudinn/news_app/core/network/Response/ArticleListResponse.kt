package com.masudinn.news_app.core.network.Response

import com.masudinn.news_app.features.home.model.Articles

data class ArticleListResponse(
    var status : String= "",
    var totalResult : Int = 0,
    var articles : List<Articles>
)