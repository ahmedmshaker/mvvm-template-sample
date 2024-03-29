package com.example.articles

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.articles.articles.data.local.database.ArticlesDao
import com.example.articles.articles.data.local.source.ArticleLocalDataSource
import com.example.articles.articles.data.local.source.ArticleLocalDataSourceImpl
import com.example.articles.articles.data.mapper.ArticleMapper
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class ArticlesLocalDataSourceTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()


    lateinit var articleLocalDataSource: ArticleLocalDataSource


    @Mock
    lateinit var articlesDao: ArticlesDao


    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)

        articleLocalDataSource = ArticleLocalDataSourceImpl(articlesDao, ArticleMapper(Gson()) , mainCoroutineRule.coroutineContext)
    }


    @Test
    fun testInvalidEntityArticles()=mainCoroutineRule.runBlockingTest{
        Mockito.`when`(articlesDao.getArticles(BuildConfig.API_KEY)).thenReturn(null)

        val result = articleLocalDataSource.getArticles()

        assert(result == null)
    }





}