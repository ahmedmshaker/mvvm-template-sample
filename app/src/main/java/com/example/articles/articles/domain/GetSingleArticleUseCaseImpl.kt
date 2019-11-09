package com.example.articles.articles.domain

import androidx.lifecycle.LiveData
import com.example.articles.articles.data.models.Article
import com.example.articles.articles.data.repository.ArticleRepository
import com.example.articles.common.Result
import javax.inject.Inject

class GetSingleArticleUseCaseImpl @Inject constructor(internal val articleRepository: ArticleRepository) :
    GetSingleArticleUseCase {

    override suspend fun getArticleById(id: Long) = articleRepository.getArticleById(id)

}