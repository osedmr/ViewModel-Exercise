package com.example.viewmodelexercise.ui.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelexercise.R
import com.example.viewmodelexercise.databinding.ActivityObservableBinding
import com.example.viewmodelexercise.ui.viewmodel.ObservableViewModel

class ObservableActivity : AppCompatActivity() {
    private lateinit var binding: ActivityObservableBinding
    private lateinit var viewmodelObservable : ObservableViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityObservableBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewmodelObservable = ViewModelProvider(this).get(ObservableViewModel::class.java)



        // liviData  observable edilecek

        viewmodelObservable.currentNumber.observe(this, Observer {number ->
            binding.textNumber.text = number.toString()
        })


        viewmodelObservable.currentBoolean.observe(this, Observer {boolean ->
            binding.textBoolean.text = boolean.toString()
        })

        binding.add.setOnClickListener {
            viewmodelObservable.addNumber()

        }


        // Timer İşlemi


        binding.start.setOnClickListener {
            viewmodelObservable.startTime()
        }

        binding.stop.setOnClickListener {
            viewmodelObservable.stopTimer()
        }

        viewmodelObservable.second.observe(this, Observer {second ->
            binding.textCount.text = second.toString()
        })

        viewmodelObservable.iscountFinish.observe(this,Observer{isFinish ->
            if(isFinish){
                binding.textCount.text = "Finish"
            }

        })

    }
}