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
    val catLiveData: MutableLiveData<List<CatModel>> = MutableLiveData()
    val dogLiveData: MutableLiveData<List<DogModel>> = MutableLiveData()
    val loadingLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val errorLiveData: MutableLiveData<String> = MutableLiveData()

    fun getCat() {
        viewModelScope.launch {
            loadingLiveData.value = true
            try {
                catLiveData.value = catRepository.random()
            } catch (e: Exception) {
                errorLiveData.value = e.toString()
            }
            loadingLiveData.value = false
        }
    }

    fun getDog() {
        viewModelScope.launch {
            loadingLiveData.value = true
            try {
                dogLiveData.value = dogRepository.random()
            } catch (e: Exception) {
                errorLiveData.value = e.toString()
            }
            loadingLiveData.value = false
        }
    }
}
