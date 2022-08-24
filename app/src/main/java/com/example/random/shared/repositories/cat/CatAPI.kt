package com.example.random.shared.repositories.cat

import com.example.random.shared.constants.APIConstants
import com.example.random.shared.repositories.cat.models.CatModel
import retrofit2.http.GET
import retrofit2.http.Query

interface CatAPI {
    @GET("images/search")
    suspend fun random(@Query("api_key") apiKey: String = APIConstants.Cat.apiKey): List<CatModel>
}
