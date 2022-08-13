package com.example.random.shared.networking

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

interface Networking {
    fun build(baseUrl: String): Retrofit
}

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkingModule {

    @Singleton
    @Binds
    abstract fun bindNetworking(
        networkingImpl: NetworkingImpl
    ): Networking
}

class NetworkingImpl @Inject constructor(): Networking {

    private val client: OkHttpClient by lazy {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    override fun build(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}