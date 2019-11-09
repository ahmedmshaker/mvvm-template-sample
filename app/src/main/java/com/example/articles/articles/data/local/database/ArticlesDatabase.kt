package com.example.articles.articles.data.local.database

import android.content.Context
import androidx.annotation.NonNull
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.articles.articles.data.local.entities.ArticlesEntity


@Database(
    entities = [ArticlesEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ArticlesDatabase : RoomDatabase() {

    companion object {
        private val LOCK = Any()
        private const val DATABASE_NAME = "articles.db"
        @Volatile
        private var INSTANCE: ArticlesDatabase? = null

        fun getInstance(@NonNull context: Context): ArticlesDatabase {
            if (INSTANCE == null) {
                synchronized(LOCK) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context,
                            ArticlesDatabase::class.java,
                            DATABASE_NAME
                        ).build()
                    }
                }
            }
            return INSTANCE!!
        }
    }

    abstract fun getArticleDao(): ArticlesDao

}