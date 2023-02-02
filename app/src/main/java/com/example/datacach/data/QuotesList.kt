package com.example.datacach.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quotes")
data class QuotesList(
    val text: String,
    @PrimaryKey val author: String

)

