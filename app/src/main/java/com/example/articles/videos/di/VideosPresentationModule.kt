package com.example.articles.videos.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.articles.videos.presentation.viewmodel.VideosViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class VideosPresentationModule {
    @Binds
    abstract fun bindsViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(VideosViewModel::class)
    abstract fun bindsHomeViewModel(mVideosViewModel: VideosViewModel): ViewModel
}