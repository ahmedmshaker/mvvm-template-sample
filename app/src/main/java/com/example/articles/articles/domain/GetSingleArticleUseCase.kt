package com.example.articles.articles.domain

import androidx.lifecycle.LiveData
import com.example.articles.articles.data.models.Article
import com.example.articles.common.BaseUseCase
import com.example.articles.common.Result

interface GetSingleArticleUseCase {

    suspend fun getArticleById(id: Long): LiveData<Result<Article>>

}