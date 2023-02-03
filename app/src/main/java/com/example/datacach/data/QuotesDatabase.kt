package com.example.datacach.data

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities =  [QuotesList::class], version = 1)
abstract class QuotesDatabase :RoomDatabase() {

    abstract  fun quotesDao(): QuotesDao

}