package com.example.random.application

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.random.R
import com.example.random.shared.repositories.cat.CatRepository
import com.example.random.shared.repositories.cat.models.CatModel
import com.example.random.shared.repositories.dog.DogRepository
import com.example.random.shared.repositories.dog.models.DogModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity()  {

    @Inject
    lateinit var catRepository: CatRepository
    @Inject
    lateinit var dogRepository: DogRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kotlin.run {
            try {
                val instance = catRepository.random().enqueue(object : Callback<List<CatModel>> {
                    override fun onResponse(
                        call: Call<List<CatModel>>,
                        response: Response<List<CatModel>>
                    ) {
                        println(response.toString())
                    }

                    override fun onFailure(call: Call<List<CatModel>>, t: Throwable) {
                        println(call.toString())
                    }
                })
                println(instance.toString())
            } catch (e: Exception) {
                println(e.localizedMessage)
            }
        }
        kotlin.run {
            try {
                val instance = dogRepository.random().enqueue(object : Callback<List<DogModel>> {
                    override fun onResponse(
                        call: Call<List<DogModel>>,
                        response: Response<List<DogModel>>
                    ) {
                        println(response.toString())
                    }
                    override fun onFailure(call: Call<List<DogModel>>, t: Throwable) {
                        println(call.toString())
                    }
                })
                println(instance.toString())
            } catch (e: Exception) {
                println(e.localizedMessage)
            }
        }
    }
}




