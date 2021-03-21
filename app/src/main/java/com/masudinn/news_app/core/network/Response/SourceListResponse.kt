package com.masudinn.news_app.core.network.Response

import com.masudinn.news_app.features.home.model.Sources

data class SourceListResponse(
    val status: String?,
    val sources: List<Sources>
)