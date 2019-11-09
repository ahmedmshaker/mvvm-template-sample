package com.example.articles.articles.data.local.source

import com.example.articles.BuildConfig
import com.example.articles.articles.data.local.database.ArticlesDao
import com.example.articles.articles.data.mapper.ArticleMapper
import com.example.articles.articles.data.models.Article
import com.example.articles.di.qualifiers.CoroutinesIO
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ArticleLocalDataSourceImpl @Inject constructor(
    private val articlesDao: ArticlesDao,
    private val articleMapper: ArticleMapper ,
    @CoroutinesIO private val context: CoroutineContext
) : ArticleLocalDataSource {

    override suspend fun getArticles() = withContext(context) {
        val articleEntity = articlesDao.getArticles(BuildConfig.API_KEY)
        if (articleEntity != null)
            articleMapper.to(articleEntity)
        else
            null
    }

    override suspend fun saveArticles(articles: List<Article>) = withContext(context) {
        val articlesEntity = articleMapper.from(articles)
        articlesDao.insertArticle(articlesEntity)

    }

    override suspend fun getArticleById(id: Long) = withContext(context) {
        val articles = getArticles()
        articles?.find { article -> article.id == id }
    }
}