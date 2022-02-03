package com.example.yummyproject

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIMethodInterface {
    @GET("mostviewed/{section}/{period}.json")
    fun getArticles(@Path("section") section: String,
                    @Path("period") period: String,
                    @Query("api-key") apiKey : String) : Call<ResponseArticle>
}