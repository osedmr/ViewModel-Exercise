package com.example.viewmodelexercise.ui.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelexercise.R
import com.example.viewmodelexercise.databinding.ActivityShared2Binding
import com.example.viewmodelexercise.ui.SharedProviderFactory
import com.example.viewmodelexercise.ui.viewmodel.SharedViewModel

class SharedActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityShared2Binding
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityShared2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        sharedViewModel = ViewModelProvider(this, SharedProviderFactory(application)).get(SharedViewModel::class.java)

        sharedViewModel.second.observe(this, Observer {second ->
            binding.textCount.text = second.toString()

        })

        sharedViewModel.currentBoolean.observe(this, Observer { it ->
            binding.textBoolean.text = it.toString()
        })
        sharedViewModel.currentNumber.observe(this, Observer {it ->
            binding.textNumber.text = it.toString()
        })

        sharedViewModel.background.observe(this, Observer {it ->
            binding.main.setBackgroundResource(it)
        })

    }
}