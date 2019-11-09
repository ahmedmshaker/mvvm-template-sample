package com.example.articles

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import com.example.articles.articles.data.models.Article
import com.example.articles.articles.data.repository.ArticleRepository
import com.example.articles.articles.domain.GetArticlesUseCase
import com.example.articles.articles.domain.GetArticlesUseCaseImpl
import com.example.articles.common.Result
import com.example.articles.common.Status
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class GetArticlesUseCaseTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()


    lateinit var getArticlesUseCase: GetArticlesUseCase

    lateinit var articleRepository: ArticleRepository

    val fakeArticles = listOf(
        Article(
            123344,
            "Hello ",
            123L,
            "shika",
            "hhhh",
            "",
            "12/2/3333",
            "4",
            "",
            "",
            "",
            "",
            "",
            1,
            emptyList()
        )
    )




    @Test
    fun testLoadingData()=mainCoroutineRule.runBlockingTest{
            articleRepository = mock {
                onBlocking { getArticles(false) } doReturn object : LiveData<Result<List<Article>>>() {
                    init {
                        value = Result.loading()
                    }
                }
            }
            getArticlesUseCase = GetArticlesUseCaseImpl(articleRepository)

            val result = getArticlesUseCase.getArticles()

            result.observeForever {  }

            assert(LiveDataTestUtil.getValue(result).status == Status.LOADING)

        }


    @Test
    fun testSuccessData()=mainCoroutineRule.runBlockingTest{
        articleRepository = mock {
            onBlocking { getArticles(false) } doReturn object : LiveData<Result<List<Article>>>() {
                init {
                    value = Result.success(fakeArticles)
                }
            }
        }
        getArticlesUseCase = GetArticlesUseCaseImpl(articleRepository)

        val result = getArticlesUseCase.getArticles()

        result.observeForever {  }

        assert(LiveDataTestUtil.getValue(result).status == Status.SUCCESS && LiveDataTestUtil.getValue(result).data == fakeArticles)

    }

    @Test
    fun testErrorData()=mainCoroutineRule.runBlockingTest{
        articleRepository = mock {
            onBlocking { getArticles(false) } doReturn object : LiveData<Result<List<Article>>>() {
                init {
                    value = Result.error("error")
                }
            }
        }
        getArticlesUseCase = GetArticlesUseCaseImpl(articleRepository)

        val result = getArticlesUseCase.getArticles()

        result.observeForever {  }

        assert(LiveDataTestUtil.getValue(result).status == Status.ERROR && LiveDataTestUtil.getValue(result).message == "error")

    }


}