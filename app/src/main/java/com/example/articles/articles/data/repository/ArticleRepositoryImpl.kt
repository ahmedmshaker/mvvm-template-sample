package com.example.articles.articles.data.repository

import androidx.lifecycle.liveData
import com.example.articles.articles.data.local.source.ArticleLocalDataSource
import com.example.articles.articles.data.models.Article
import com.example.articles.articles.data.remote.source.ArticleRemoteDataSource
import com.example.articles.common.Result
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val localDataSource: ArticleLocalDataSource,
    private val remoteDataSource: ArticleRemoteDataSource
) : ArticleRepository {


    override suspend fun getArticles(mustFetchFromNetwork: Boolean) = liveData {
        emit(Result.loading<List<Article>>())
        try {

            var articles: List<Article>? = null
            if (!mustFetchFromNetwork)
                articles = localDataSource.getArticles()


            if (articles == null) {
                articles = remoteDataSource.getArticles()
                localDataSource.saveArticles(articles)
            }
            emit(Result.success(articles))

        } catch (exception: Exception) {
            emit(Result.error<List<Article>>(exception.message ?: ""))
        }
    }

    override suspend fun getArticleById(id: Long) = liveData {
        emit(Result.loading<Article>())
        try {
            val article = localDataSource.getArticleById(id)
            if (article != null)
                emit(Result.success(article))
            else
                emit(Result.error<Article>("there is no articles"))
        } catch (exception: Exception) {
            emit(Result.error<Article>(exception.message ?: ""))

        }
    }
}