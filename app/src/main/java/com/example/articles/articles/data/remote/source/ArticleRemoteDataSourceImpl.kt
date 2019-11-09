package com.example.articles.articles.data.remote.source

import com.example.articles.BuildConfig
import com.example.articles.articles.data.remote.services.ArticlesService
import com.example.articles.di.qualifiers.CoroutinesIO
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ArticleRemoteDataSourceImpl @Inject constructor(
    private val articlesService: ArticlesService,
    @CoroutinesIO private val context: CoroutineContext
    )
    : ArticleRemoteDataSource {

    override suspend fun getArticles()= withContext(context) {
        val response = articlesService.getArticlesAsync(BuildConfig.API_KEY).await()

        if (response.isSuccessful)
             response.body()?.articles ?: throw Exception("no Articles")
        else
            throw Exception("invalid request with code ${response.code()}")


    }

}