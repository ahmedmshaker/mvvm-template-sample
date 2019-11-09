package com.example.articles.news.di


import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import com.example.articles.news.data.remote.source.NewsRemoteDataSource
import com.example.articles.news.data.remote.source.NewsRemoteDataSourceImpl
import com.example.articles.news.data.remote.services.NewsService


@Module(includes = [NewsRemoteModule.Binders::class])
class NewsRemoteModule {


    @Module
    interface Binders {


        @Binds
        fun bindsRemoteSource(
            remoteDataSourceImpl: NewsRemoteDataSourceImpl
        ): NewsRemoteDataSource


    }


    @Provides
    fun providesNewsService(retrofit: Retrofit): NewsService =
        retrofit.create(NewsService::class.java)


}