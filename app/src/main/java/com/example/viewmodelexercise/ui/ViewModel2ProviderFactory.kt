package com.example.viewmodelexercise.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelexercise.ui.viewmodel.ViewModel2

@Suppress("UNCHECKED_CAST") //tip denetimi esnasında hatayı bastırır
class ViewModel2ProviderFactory(val sayi :Int) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(ViewModel2::class.java)) {
            return ViewModel2(sayi) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}