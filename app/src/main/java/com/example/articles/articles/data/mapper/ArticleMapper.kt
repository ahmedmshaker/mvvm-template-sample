package com.example.articles.articles.data.mapper

import com.example.articles.BuildConfig
import com.example.articles.articles.data.local.entities.ArticlesEntity
import com.example.articles.articles.data.models.Article
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class ArticleMapper @Inject constructor(val gson: Gson) : Mapper<ArticlesEntity, List<Article>> {
    override fun from(e: List<Article>) = ArticlesEntity(BuildConfig.API_KEY, gson.toJson(e))


    override fun to(t: ArticlesEntity): List<Article> {
        return gson.fromJson(
            t.response, TypeToken.getParameterized(ArrayList::class.java, Article::class.java).type
        )
    }
}