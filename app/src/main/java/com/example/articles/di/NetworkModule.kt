package com.example.articles.di

import com.example.articles.BuildConfig
import com.example.articles.di.qualifiers.CoroutinesIO
import com.example.articles.di.qualifiers.CoroutinesMainThread
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext

@Module
class NetworkModule {

    @Provides
    fun providesGson(): Gson = Gson()

    @Provides
    fun providesRetrofit(gson: Gson): Retrofit =
        Retrofit.Builder()
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BuildConfig.BASE_URL)
            .build()


    @CoroutinesIO
    @Provides
    fun providesIoDispatcher(): CoroutineContext = Dispatchers.IO

    @CoroutinesMainThread
    @Provides
    fun providesMainThreadDispatcher(): CoroutineContext = Dispatchers.Main

}