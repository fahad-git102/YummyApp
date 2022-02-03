package com.example.yummyproject

import com.google.gson.annotations.SerializedName

class MediaMetadatum {
    @SerializedName("url")
    var url: String? = null

    @SerializedName("format")
    var format: String? = null

    @SerializedName("height")
    var height: Int? = null

    @SerializedName("width")
    var width: Int? = null
}