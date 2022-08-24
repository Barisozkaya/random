package com.example.random.scene.details

import androidx.lifecycle.liveData
import com.example.random.shared.base.BaseViewModel
import com.example.random.shared.repositories.cat.CatRepository
import com.example.random.shared.repositories.dog.DogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val CatRepository: CatRepository,private val DogRepository: DogRepository) : BaseViewModel() {
    fun getPosts() = liveData(Dispatchers.IO) {
        emit(CatRepository.random())
    }

    fun getPost() = liveData(Dispatchers.IO) {
        emit(DogRepository.random())
    }
}