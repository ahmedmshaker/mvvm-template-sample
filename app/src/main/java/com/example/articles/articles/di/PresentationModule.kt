package com.example.articles.articles.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.articles.articles.presentation.viewmodel.ArticlesViewModel
import com.example.articles.articles.presentation.viewmodel.ViewModelFactory
import com.example.articles.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PresentationModule {
    @Binds
    abstract fun bindsViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ArticlesViewModel::class)
    abstract fun bindsHomeViewModel(homeVM: ArticlesViewModel): ViewModel
}