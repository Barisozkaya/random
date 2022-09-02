package com.example.random.scene.details

import com.example.random.shared.base.BaseViewModel
import com.example.random.shared.repositories.cat.CatRepository
import com.example.random.shared.repositories.dog.DogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val CatRepository: CatRepository,
    private val DogRepository: DogRepository
) : BaseViewModel()
