package com.example.articles.news.data.remote.source

import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext
import com.example.articles.news.data.remote.services.NewsService


class NewsRemoteDataSourceImpl @Inject constructor(
    private val service: NewsService,
    @IO private val context: CoroutineContext
) : NewsRemoteDataSource {

//  Example for Sync API calls
//    override suspend fun requestArticles()= withContext(context) {
//        val response = articlesService.requestArticlesAsync(BuildConfig.API_KEY).await()
//
//        if (response.isSuccessful)
//             response.body()?.articles ?: throw Exception("no Articles")
//        else
//            throw Exception("invalid request with code + response.code()")
//   }

}
