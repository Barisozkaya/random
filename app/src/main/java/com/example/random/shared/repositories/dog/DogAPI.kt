package com.example.random.shared.repositories.dog

import com.example.random.shared.constants.APIConstants
import com.example.random.shared.repositories.dog.models.DogModel
import retrofit2.http.GET
import retrofit2.http.Query

interface DogAPI {
    @GET("images/search")
    suspend fun random(@Query("api_key") apiKey: String = APIConstants.Dog.apiKey): List<DogModel>
}
