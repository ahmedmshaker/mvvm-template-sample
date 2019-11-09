package com.example.articles.articles.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.articles.articles.data.local.entities.ArticlesEntity

@Dao
abstract class ArticlesDao {
    @Query("SELECT * FROM ArticlesEntity WHERE id = :id")
    abstract suspend fun getArticles(id: String): ArticlesEntity?

    @Insert(onConflict = REPLACE)
    abstract fun insertArticle(articlesEntity: ArticlesEntity)
}