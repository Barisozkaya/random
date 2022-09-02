package com.example.random.shared.repositories.dog.models

import com.google.gson.annotations.SerializedName

data class DogModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int,
    @SerializedName("height")
    val height: Int
)
