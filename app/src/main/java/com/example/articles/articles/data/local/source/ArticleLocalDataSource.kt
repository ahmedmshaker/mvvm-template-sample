package com.example.articles.articles.data.local.source

import com.example.articles.articles.data.models.Article

interface ArticleLocalDataSource {
    suspend fun getArticles(): List<Article>?
    suspend fun saveArticles(articles: List<Article>)
    suspend fun getArticleById(id: Long):Article?
}