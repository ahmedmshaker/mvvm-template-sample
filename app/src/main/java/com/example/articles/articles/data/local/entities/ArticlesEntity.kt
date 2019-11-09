package com.example.articles.articles.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArticlesEntity(

    @PrimaryKey val id: String,
    val response: String
)
