package com.exemple.jetgyfs.data.data_source.api

import com.exemple.jetgyfs.domain.model.ListGiff
import com.exemple.jetgyfs.networking.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GifApi {
    @GET("trending")
    suspend fun getRandomGifs(
        @Query("api_key") key: String = Constants.api_key,
        @Query("limit") limit: Int = 26,
        @Query("rating") lang: String = "pg"
    ): Response<ListGiff>

    @GET("search")
    suspend fun getSearchGifs(
        @Query("api_key") key: String = Constants.api_key,
        @Query("q") search: String,
        @Query("limit") limit: Int = 25,
        @Query("offset") offset: Int = 0,
        @Query("rating") rating: String = "g",
        @Query("lang") lang: String = "en"
    ): Response<ListGiff>
}