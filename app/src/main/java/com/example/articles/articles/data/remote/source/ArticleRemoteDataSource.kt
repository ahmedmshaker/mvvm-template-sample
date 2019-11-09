package com.example.articles.articles.data.remote.source

import com.example.articles.articles.data.models.Article

interface ArticleRemoteDataSource {
    suspend fun getArticles(): List<Article>
}