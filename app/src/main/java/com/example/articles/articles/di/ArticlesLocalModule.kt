package com.example.articles.articles.di

import android.app.Application
import com.example.articles.articles.data.local.database.ArticlesDatabase
import com.example.articles.articles.data.local.source.ArticleLocalDataSource
import com.example.articles.articles.data.local.source.ArticleLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(includes = [ArticlesLocalModule.Binders::class])
class ArticlesLocalModule {

    @Module
    interface Binders {
        @Binds
        fun bindsLocalDataSource(
            localDataSourceImpl: ArticleLocalDataSourceImpl
        ): ArticleLocalDataSource

    }

    @Provides
    @Singleton
    fun providesDatabase(
        application: Application
    ) = ArticlesDatabase.getInstance(application.applicationContext)

    @Provides
    @Singleton
    fun providesArticleDao(
        bankBuddyDB: ArticlesDatabase
    ) = bankBuddyDB.getArticleDao()


}