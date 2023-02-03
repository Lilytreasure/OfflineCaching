package com.example.datacach.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface QuotesDao {
    //data access object
    @Query(value = "SELECT ALL * FROM  quotes")
    fun getAllQuotes():Flow<List<QuotesList>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertQuotes(quotes: List<QuotesList>)

     @Query(value = "DELETE  FROM quotes")
    suspend fun  deleteAllQuotes()


}