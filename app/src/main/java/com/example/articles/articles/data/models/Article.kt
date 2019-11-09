package com.example.articles.articles.data.models

import com.example.populararticles.data.Media


data class Article(
    val id: Long,
    val adx_keywords: String,
    val asset_id: Long,
    val byline: String,
    val column: String,
    val geo_facet: Any,
    val published_date: String,
    val section: String,
    val source: String,
    val title: String,
    val type: String,
    val uri: String,
    val url: String,
    val views: Int,
    val media: List<Media>
)
