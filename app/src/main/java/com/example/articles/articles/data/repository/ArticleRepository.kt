package com.example.articles.articles.data.repository

import androidx.lifecycle.LiveData
import com.example.articles.articles.data.models.Article
import com.example.articles.common.Result

interface ArticleRepository {
    suspend fun getArticles(mustFetchFromNetwork: Boolean): LiveData<Result<List<Article>>>
    suspend fun getArticleById(id: Long): LiveData<Result<Article>>
}