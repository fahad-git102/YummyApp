package com.example.yummyproject

import com.google.gson.annotations.SerializedName

class Result {
    @SerializedName("uri")
    var uri: String? = null

    @SerializedName("url")
    var url: String? = null

    @SerializedName("id")
    var id: Long? = null

    @SerializedName("asset_id")
    var assetId: Long? = null

    @SerializedName("source")
    var source: String? = null

    @SerializedName("published_date")
    var publishedDate: String? = null

    @SerializedName("updated")
    var updated: String? = null

    @SerializedName("section")
    var section: String? = null

    @SerializedName("subsection")
    var subsection: String? = null

    @SerializedName("nytdsection")
    var nytdsection: String? = null

    @SerializedName("adx_keywords")
    var adxKeywords: String? = null

    @SerializedName("column")
    var column: Any? = null

    @SerializedName("byline")
    var byline: String? = null

    @SerializedName("type")
    var type: String? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("abstract")
    var abstract: String? = null

    @SerializedName("des_facet")
    var desFacet: List<String>? = null

    @SerializedName("org_facet")
    var orgFacet: List<String>? = null

    @SerializedName("per_facet")
    var perFacet: List<String>? = null

    @SerializedName("geo_facet")
    var geoFacet: List<String>? = null

    @SerializedName("media")
    var media: List<Medium>? = null

    @SerializedName("eta_id")
    var etaId: Int? = null
}