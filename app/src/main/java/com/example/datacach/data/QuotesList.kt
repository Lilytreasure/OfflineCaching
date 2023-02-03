package com.example.datacach.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quotes")

data class QuotesList(
    //The api may have null author values which will throw a not null exception
     val text: String,
    @PrimaryKey val author: String
    
)

