package com.example.articles.videos.data.remote.source

import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext
import com.example.articles.videos.data.remote.services.VideosService


class VideosRemoteDataSourceImpl @Inject constructor(
    private val service: VideosService,
    @CoroutinesIO private val context: CoroutineContext
) : VideosRemoteDataSource {

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
