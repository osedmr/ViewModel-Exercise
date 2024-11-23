package com.example.viewmodelexercise.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelexercise.ui.viewmodel.SharedViewModel
import com.example.viewmodelexercise.ui.viewmodel.ViewModel2

class SharedProviderFactory (private val application: Application) : ViewModelProvider.Factory {

    //Instance Olayı
    companion object {
        private var INSTANCE: SharedViewModel? = null

        fun getInstance(application: Application): SharedViewModel =
            INSTANCE ?: synchronized(this){
                INSTANCE ?: SharedViewModel(application).also { INSTANCE = it }
            }
        }



    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(SharedViewModel::class.java)) {
            return getInstance(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}