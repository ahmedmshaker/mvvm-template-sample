package com.example.articles.videos.domain

import com.example.articles.videos.data.repository.VideosRepository
import javax.inject.Inject

class UseCaseImpl @Inject constructor(private val mVideosRepository: VideosRepository) : UseCase {

}
