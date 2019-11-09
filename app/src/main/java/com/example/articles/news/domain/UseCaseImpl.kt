package com.example.articles.news.domain

import com.example.articles.news.data.repository.NewsRepository
import javax.inject.Inject

class UseCaseImpl @Inject constructor(private val mNewsRepository: NewsRepository) : UseCase {

}
