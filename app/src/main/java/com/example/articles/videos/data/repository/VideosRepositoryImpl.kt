package com.example.articles.videos.data.repository


import javax.inject.Inject
import com.example.articles.videos.data.remote.source.VideosRemoteDataSource


class VideosRepositoryImpl @Inject constructor(
    private val remoteDataSource: VideosRemoteDataSource
) : VideosRepository {


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