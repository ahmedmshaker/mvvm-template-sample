package com.example.articles.articles.di

import com.example.articles.articles.data.remote.services.ArticlesService
import com.example.articles.articles.data.remote.source.ArticleRemoteDataSource
import com.example.articles.articles.data.remote.source.ArticleRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [ArticlesRemoteModule.Binders::class])
class ArticlesRemoteModule {

    @Module
    interface Binders {

        @Binds
        fun bindsRemoteSource(
            remoteDataSourceImpl: ArticleRemoteDataSourceImpl
        ): ArticleRemoteDataSource

    }

    @Provides
    fun providesArticlesService(retrofit: Retrofit): ArticlesService =
        retrofit.create(ArticlesService::class.java)

}