package com.example.random.scene.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.random.shared.base.BaseViewModel
import com.example.random.shared.repositories.cat.CatRepository
import com.example.random.shared.repositories.cat.models.CatModel
import com.example.random.shared.repositories.dog.DogRepository
import com.example.random.shared.repositories.dog.models.DogModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val catRepository: CatRepository,
    private val dogRepository: DogRepository
) : BaseViewModel() {

    val cat: MutableLiveData<List<CatModel>> = MutableLiveData()
    val dog: MutableLiveData<List<DogModel>> = MutableLiveData()

    fun getCat() {
        viewModelScope.launch {
            loading.value = true
            try {
                cat.value = catRepository.random()
            } catch (e: Exception) {
                error.value = e.toString()
            }
            loading.value = false
        }
    }

    fun getDog() {
        viewModelScope.launch {
            loading.value = true
            try {
                dog.value = dogRepository.random()
            } catch (e: Exception) {
                error.value = e.toString()
            }
            loading.value = false
        }
    }
}
