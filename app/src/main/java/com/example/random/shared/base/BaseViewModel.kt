package com.example.random.shared.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    val loading: MutableLiveData<Boolean> = MutableLiveData()
    val error: MutableLiveData<String> = MutableLiveData()
}
