package com.example.viewmodelexercise.ui.viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentSharedViewModel : ViewModel()  {



    var lenguage = MutableLiveData<String>("kotlin")

    fun passLanguageData(language: String){
        lenguage.value = language

    }

    // timmer
    private lateinit var timer : CountDownTimer

    val second = MutableLiveData<Int>()
    var isRunning = false
    val iscountFinish = MutableLiveData<Boolean>()

    fun startTime(){
        timer = object  : CountDownTimer(10000,1000){
            override fun onTick(millisUntilFinished: Long) {
                val timeLeft = millisUntilFinished / 1000
                second.value = timeLeft.toInt()
                isRunning = true
            }

            override fun onFinish() {
                iscountFinish.value = true
                isRunning = false
                stopTimer()
            }

        }.start()
    }

    fun stopTimer(){
        timer.cancel()
    }
}