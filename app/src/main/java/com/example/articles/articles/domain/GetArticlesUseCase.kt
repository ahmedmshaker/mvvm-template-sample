package com.example.articles.articles.domain

import androidx.lifecycle.LiveData
import com.example.articles.articles.data.models.Article
import com.example.articles.common.Result

interface GetArticlesUseCase {

    suspend fun getArticles(mustFetchFromNetwork: Boolean = false): LiveData<Result<List<Article>>>
}