package com.example.articles.news.di

import com.example.articles.news.data.repository.NewsRepository
import com.example.articles.news.data.repository.NewsRepositoryImpl
import com.example.articles.news.domain.UseCaseImpl
import com.example.articles.news.domain.UseCase
import dagger.Binds
import dagger.Module

@Module
abstract class NewsDomainModule {

    @Binds
    abstract fun bindsRepository(
        repoImpl: NewsRepositoryImpl
    ): NewsRepository


    @Binds
    abstract fun bindsArticlesUseCase(
        mUseCase: UseCaseImpl
    ): UseCase


}