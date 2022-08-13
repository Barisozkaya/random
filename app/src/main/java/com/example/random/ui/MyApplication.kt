package com.example.random.ui

import android.app.Application
import android.content.pm.PackageManager
import com.example.random.shared.constants.APIConstants
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        this.packageManager.getApplicationInfo(this.packageName, PackageManager.GET_META_DATA)
            .let {
                APIConstants.Cat.apiKey = it.metaData.getString("CAT_API_KEY") ?: ""
                APIConstants.Dog.apiKey = it.metaData.getString("DOG_API_KEY") ?: ""
            }
    }
}