package com.android.asif.llc.kotlin.trendymovies.android.model.tv

import com.google.gson.annotations.SerializedName

data class TvGenres (

    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String
)