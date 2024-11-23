package com.example.viewmodelexercise.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.viewmodelexercise.R

class ViewModel1 : ViewModel() {

    //business logic işlemleri olur
    val TAG ="ViewModel1"

    var number = 0

    fun addNumber(){
        number++

    }

    var background : Int = R.color.red
    fun changeBackground(){
        if(background == R.color.red){
            background = R.color.white
        }else{
            background = R.color.red
        }
    }
}