package com.masudinn.news_app.core.Network.Response

data class ArticleListResponse(
    var status : String= "",
    var totalResult : Int = 0,
    var articles : List<Articles>
)