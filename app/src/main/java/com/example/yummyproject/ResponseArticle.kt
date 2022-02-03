package com.example.yummyproject

import com.google.gson.annotations.SerializedName

class ResponseArticle {
    @SerializedName("status")
    var status: String? = null

    @SerializedName("copyright")
    var copyright: String? = null

    @SerializedName("num_results")
    var numResults: Int? = null

    @SerializedName("results")
    var results: List<Result>? = null
}