package com.example.viewmodelexercise.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.navigation.navGraphViewModels
import com.example.viewmodelexercise.R
import com.example.viewmodelexercise.databinding.FragmentSecondBinding
import com.example.viewmodelexercise.ui.viewmodel.FragmentSharedViewModel


class SecondFragment : Fragment() {

    private lateinit var binding : FragmentSecondBinding
    //private lateinit var viewModel: FragmentSharedViewModel
    private val viewModel: FragmentSharedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       // viewModel = ViewModelProvider(requireActivity()).get(FragmentSharedViewModel::class.java)


        viewModel.lenguage.observe(viewLifecycleOwner){
            binding.textView.text = it
        }

        viewModel.second.observe(viewLifecycleOwner){
            binding.textCount.text = it.toString()
        }

    }

}