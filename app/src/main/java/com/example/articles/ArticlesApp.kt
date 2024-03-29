package com.example.articles

import com.example.articles.di.DaggerArticleAppComponent
import com.facebook.drawee.backends.pipeline.Fresco
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class ArticlesApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerArticleAppComponent.builder().application(this).build()

    }

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this);
    }


}