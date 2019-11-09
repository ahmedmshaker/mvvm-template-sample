package com.example.articles.articles.presentation.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.articles.articles.data.models.Article
import com.example.articles.articles.domain.GetArticlesUseCase
import com.example.articles.articles.domain.GetSingleArticleUseCase
import com.example.articles.common.Result
import kotlinx.coroutines.launch
import javax.inject.Inject


class ArticlesViewModel @Inject constructor(
    private val getArticlesUseCase: GetArticlesUseCase
    , private val getSingleArticleUseCase: GetSingleArticleUseCase
) : ViewModel() {


//if you don't need to change your source you can do like this
//    val articleResult = liveData {
//        emitSource(getArticlesUseCase.getArticles())
//    }


    val articleResult = MediatorLiveData<Result<List<Article>>>()


    init {
        loadArticles(false)
    }

    fun loadArticles(mustFetchFromNetwork: Boolean) {
        viewModelScope.launch {
            articleResult.addSource(getArticlesUseCase.getArticles(mustFetchFromNetwork)) {
                articleResult.value = it
            }
        }
    }

    val singleArticleResult = MediatorLiveData<Result<Article>>()

    fun loadSingleArticle(id: Long) {
        viewModelScope.launch {
            singleArticleResult.addSource(getSingleArticleUseCase.getArticleById(id)) {
                singleArticleResult.value = it
            }
        }
    }


}