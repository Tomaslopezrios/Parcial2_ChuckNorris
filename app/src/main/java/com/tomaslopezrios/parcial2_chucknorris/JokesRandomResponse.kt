package com.tomaslopezrios.parcial2_chucknorris

import com.google.gson.annotations.SerializedName

data class JokesRandomResponse(

    @SerializedName("icon_url") val iconUrl: String,
    @SerializedName("id") val id: String,
    @SerializedName("url") val url: String,
    @SerializedName("value") val value: String
)

data class JokesRandomResponseByCategory(
    @SerializedName("value") val value: String
)



