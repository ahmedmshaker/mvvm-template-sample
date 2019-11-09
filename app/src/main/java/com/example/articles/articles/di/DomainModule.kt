package com.example.articles.articles.di

import com.example.articles.articles.data.repository.ArticleRepository
import com.example.articles.articles.data.repository.ArticleRepositoryImpl
import com.example.articles.articles.domain.GetArticlesUseCase
import com.example.articles.articles.domain.GetArticlesUseCaseImpl
import com.example.articles.articles.domain.GetSingleArticleUseCase
import com.example.articles.articles.domain.GetSingleArticleUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class DomainModule {

    @Binds
    abstract fun bindsRepository(
        repoImpl: ArticleRepositoryImpl
    ): ArticleRepository


    @Binds
    abstract fun bindsArticlesUseCase(
        articleUseCase: GetArticlesUseCaseImpl
    ): GetArticlesUseCase

    @Binds
    abstract fun bindsSingleArticlesUseCase(
        singleArticleUseCase: GetSingleArticleUseCaseImpl
    ): GetSingleArticleUseCase


}