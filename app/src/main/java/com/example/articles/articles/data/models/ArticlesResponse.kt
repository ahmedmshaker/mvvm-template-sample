package com.example.populararticles.data

import com.example.articles.articles.data.models.Article
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class ArticlesResponse(
    val copyright: String,
    val num_results: Int,
    @SerializedName("results") var articles: List<Article>,
    val status: String
):Serializable