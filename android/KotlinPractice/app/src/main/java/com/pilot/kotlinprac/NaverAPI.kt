package com.pilot.kotlinprac

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

// NaverAPI.kt interface
interface NaverAPI {
    @GET("https://openapi.naver.com/v1/search/news.json")
    fun getSearchNews(
        @Header("X-Naver-Client-Id") clientId: String,
        @Header("X-Naver-Client-Secret") clientSecret: String,
        @Query("query") query: String,
        @Query("display") display: Int? = null,
        @Query("start") start: Int? = null
    ): Call<ResultGetSearchNews>
}