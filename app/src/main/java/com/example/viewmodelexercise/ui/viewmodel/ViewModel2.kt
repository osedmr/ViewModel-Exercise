package com.example.viewmodelexercise.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel

class ViewModel2(val sayi :Int) : ViewModel() {

    val TAG="ViewModel2"
    fun viewModelFonk(){
        Log.e(TAG,"ViewModel2 çalıştı : $sayi")
    }
}