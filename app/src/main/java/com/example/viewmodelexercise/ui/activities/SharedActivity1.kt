package com.example.viewmodelexercise.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelexercise.R
import com.example.viewmodelexercise.databinding.ActivityShared1Binding
import com.example.viewmodelexercise.ui.SharedProviderFactory
import com.example.viewmodelexercise.ui.viewmodel.SharedViewModel

class SharedActivity1 : AppCompatActivity() {

    private lateinit var binding: ActivityShared1Binding
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityShared1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedViewModel = ViewModelProvider(this,SharedProviderFactory(application)).get(SharedViewModel::class.java)

        sharedViewModel.currentNumber.observe(this, Observer {number ->
            binding.textNumber.text = number.toString()
        })


        sharedViewModel.currentBoolean.observe(this, Observer {boolean ->
            binding.textBoolean.text = boolean.toString()
        })

        binding.add.setOnClickListener {
            sharedViewModel.addNumber()

        }

        sharedViewModel.background.observe(this, Observer {background ->
            binding.main.setBackgroundResource(background)
        })

        binding.color.setOnClickListener {
            sharedViewModel.backgroundChange()
        }


        // Timer İşlemi


        binding.start.setOnClickListener {
            sharedViewModel.startTime()
        }

        binding.stop.setOnClickListener {
            startActivity(Intent(this, SharedActivity2::class.java))
        }

        sharedViewModel.second.observe(this, Observer {second ->
            binding.textCount.text = second.toString()
        })

        sharedViewModel.iscountFinish.observe(this,Observer{isFinish ->
            if(isFinish){
                binding.textCount.text = "Finish"
            }

        })

    }

}