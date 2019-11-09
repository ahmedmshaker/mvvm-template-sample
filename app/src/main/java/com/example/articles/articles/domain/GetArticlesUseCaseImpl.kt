package com.example.articles.articles.domain

import com.example.articles.articles.data.repository.ArticleRepository
import javax.inject.Inject

class GetArticlesUseCaseImpl @Inject constructor(private val articleRepository: ArticleRepository) : GetArticlesUseCase {

    override suspend fun getArticles(mustFetchFromNetwork: Boolean) = articleRepository.getArticles(mustFetchFromNetwork)
}
