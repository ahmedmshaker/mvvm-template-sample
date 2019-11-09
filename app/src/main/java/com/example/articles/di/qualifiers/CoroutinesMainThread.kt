package com.example.articles.di.qualifiers

import javax.inject.Qualifier


@Qualifier
@MustBeDocumented
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class CoroutinesMainThread