package com.example.viewmodelexercise.ui.viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ObservableViewModel : ViewModel() {

    // Live DAta

    val currentNumber = MutableLiveData<Int>()
    val currentBoolean = MutableLiveData<Boolean>()
    private var number = 0



    fun addNumber(){
        number++
        currentNumber.value = number
        currentBoolean.value = number % 2 == 0
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