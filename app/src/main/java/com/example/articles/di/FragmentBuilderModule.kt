package com.example.articles.di

import com.example.articles.articles.presentation.ui.fragments.ArticleDetailsFragment
import com.example.articles.articles.presentation.ui.fragments.ArticlesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBuilderModule {


    @ContributesAndroidInjector
    abstract fun contributesArticlesFragment(): ArticlesFragment


    @ContributesAndroidInjector
    abstract fun contributesArticleDetailsFragment(): ArticleDetailsFragment


}