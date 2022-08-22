package com.example.random.shared.repositories.dog

import com.example.random.shared.constants.APIConstants
import com.example.random.shared.networking.Networking
import com.example.random.shared.repositories.dog.models.DogModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Call
import javax.inject.Inject

interface DogRepository {
    fun random(): Call<List<DogModel>>
}
@Module
@InstallIn(ViewModelComponent::class)
abstract class DogRepositoryModule {

    @Binds
    abstract fun bindDogRepository(
        dogRepositoryImpl: DogRepositoryImpl
    ): DogRepository
}

class DogRepositoryImpl @Inject constructor(networking: Networking) : DogRepository {

    private val api: DogAPI

    init {
        api = networking
            .build(APIConstants.Dog.baseUrl)
            .create(DogAPI::class.java)
    }

    override fun random(): Call<List<DogModel>> {
        return api.random()
    }
}






