package com.example.articles.videos.di

import com.example.articles.videos.data.repository.VideosRepository
import com.example.articles.videos.data.repository.VideosRepositoryImpl
import com.example.articles.videos.domain.UseCaseImpl
import com.example.articles.videos.domain.UseCase
import dagger.Binds
import dagger.Module

@Module
abstract class VideosDomainModule {

    @Binds
    abstract fun bindsRepository(
        repoImpl: VideosRepositoryImpl
    ): VideosRepository


    @Binds
    abstract fun bindsArticlesUseCase(
        mUseCase: UseCaseImpl
    ): UseCase


}