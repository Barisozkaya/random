package com.example.random.shared.repositories.cat

import com.example.random.shared.constants.APIConstants
import com.example.random.shared.networking.Networking
import com.example.random.shared.repositories.cat.models.CatModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Call
import javax.inject.Inject

interface  CatRepository {
    fun random(): Call<List<CatModel>>
}

@Module
@InstallIn(ActivityComponent::class)
abstract class CatRepositoryModule {

    @Binds
    abstract fun bindCatRepository(
        catRepositoryImpl: CatRepositoryImpl
    ): CatRepository
}

class CatRepositoryImpl @Inject constructor(networking: Networking) : CatRepository {

    private val api: CatAPI

    init {
        api = networking
            .build(APIConstants.Cat.baseUrl)
            .create(CatAPI::class.java)
    }

    override fun random(): Call<List<CatModel>> {
        return api.random()
    }
}