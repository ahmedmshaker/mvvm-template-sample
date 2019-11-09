package com.example.articles.di

import android.app.Application
import com.example.articles.ArticlesApp
import com.example.articles.articles.di.ArticlesLocalModule
import com.example.articles.articles.di.ArticlesRemoteModule
import com.example.articles.articles.di.DomainModule
import com.example.articles.articles.di.PresentationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton



@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        DomainModule::class,
        NetworkModule::class,
        FragmentBuilderModule::class,
        ActivityBuilderModule::class,
        ArticlesLocalModule::class,
        ArticlesRemoteModule::class,
        AppModule::class,
        PresentationModule::class
    ]
)
interface ArticleAppComponent : AndroidInjector<ArticlesApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): ArticleAppComponent
    }

    override fun inject(app: ArticlesApp)
}