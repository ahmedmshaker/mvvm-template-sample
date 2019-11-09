package com.example.articles.news.data.repository


import javax.inject.Inject
import com.example.articles.news.data.remote.source.NewsRemoteDataSource


class NewsRepositoryImpl @Inject constructor(
    private val remoteDataSource: NewsRemoteDataSource
) : NewsRepository {


// Sample Code to be deleted
//    override suspend fun getArticles(mustFetchFromNetwork: Boolean) = liveData {
//        emit(Result.loading<List<Article>>())
//        try {
//
//            var articles: List<Article>? = null
//            if (!mustFetchFromNetwork)
//                articles = localDataSource.getArticles()
//
//
//            if (articles == null) {
//                articles = remoteDataSource.requestArticles()
//                localDataSource.saveArticles(articles)
//            }
//            emit(Result.success(articles))
//
//        } catch (exception: Exception) {
//            emit(Result.error<List<Article>>(exception.message ?: ""))
//        }
//    }


}