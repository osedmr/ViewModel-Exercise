package com.example.viewmodelexercise.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelexercise.R
import com.example.viewmodelexercise.databinding.ActivityMainBinding
import com.example.viewmodelexercise.ui.ViewModel2ProviderFactory
import com.example.viewmodelexercise.ui.viewmodel.ViewModel1
import com.example.viewmodelexercise.ui.viewmodel.ViewModel2

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
   // private lateinit var viewModel1: ViewModel1
    private lateinit var viewModel2: ViewModel2

   private val viewModel1:  ViewModel1 by viewModels()
  // private val viewModel2: ViewModel2 by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


       // viewModel1 = ViewModelProvider(this).get(ViewModel1::class.java)


        binding.textNumber.text = viewModel1.number.toString()
        binding.add.setOnClickListener {
            viewModel2.viewModelFonk()
            viewModel1.addNumber()
            binding.textNumber.text = viewModel1.number.toString()

        }

        binding.main.setBackgroundColor(ContextCompat.getColor(this,viewModel1.background))
        binding.color.setOnClickListener{
            viewModel1.changeBackground()
            binding.main.setBackgroundColor(ContextCompat.getColor(this,viewModel1.background))

        }


        viewModel2 =ViewModelProvider(this, ViewModel2ProviderFactory(10)).get(ViewModel2::class.java)


        viewModel2.viewModelFonk()





        binding.buttongo.setOnClickListener {
            startActivity(Intent(this, ObservableActivity::class.java))
        }
        binding.button2go.setOnClickListener {
            startActivity(Intent(this, SharedActivity1::class.java))
        }
        binding.goToTest.setOnClickListener {
            startActivity(Intent(this, TestActivity::class.java))
        }

    }
}























