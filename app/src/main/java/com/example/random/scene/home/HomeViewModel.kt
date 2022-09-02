package com.example.random.scene.home

import androidx.lifecycle.LiveData
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
    private var _catLiveData: MutableLiveData<List<CatModel>> = MutableLiveData()
    val catLiveData: LiveData<List<CatModel>>
        get() = _catLiveData

    fun getCat() {
        viewModelScope.launch {
            _catLiveData.value = catRepository.random()
        }
    }

    private var _dogLiveData: MutableLiveData<List<DogModel>> = MutableLiveData()
    val dogLiveData: MutableLiveData<List<DogModel>>
        get() = _dogLiveData

    fun getDog() {
        viewModelScope.launch {
            _dogLiveData.value = dogRepository.random()
        }
    }
}
