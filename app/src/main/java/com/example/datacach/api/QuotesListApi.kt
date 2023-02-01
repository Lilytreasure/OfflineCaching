package com.example.datacach.api

import com.example.datacach.data.QuotesList
import retrofit2.http.GET

interface QuotesListApi {

    companion object{
        const val BASE_URL="https://type.fit/"
    }

    //Get request

    @GET("api/quotes")
    suspend fun getQuotesList():List<QuotesList>


}