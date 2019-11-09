package com.example.articles.videos.di


import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import com.example.articles.videos.data.remote.source.VideosRemoteDataSource
import com.example.articles.videos.data.remote.source.VideosRemoteDataSourceImpl
import com.example.articles.videos.data.remote.services.VideosService


@Module(includes = [VideosRemoteModule.Binders::class])
class VideosRemoteModule {


    @Module
    interface Binders {


        @Binds
        fun bindsRemoteSource(
            remoteDataSourceImpl: VideosRemoteDataSourceImpl
        ): VideosRemoteDataSource


    }


    @Provides
    fun providesVideosService(retrofit: Retrofit): VideosService =
        retrofit.create(VideosService::class.java)


}