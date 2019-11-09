package com.example.articles.articles.data.remote.services

import com.example.populararticles.data.ArticlesResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ArticlesService {

    @GET("v2/mostviewed/all-sections/7.json")
    fun getArticlesAsync(@Query("api-key") apiKey: String): Deferred<Response<ArticlesResponse>>

}

