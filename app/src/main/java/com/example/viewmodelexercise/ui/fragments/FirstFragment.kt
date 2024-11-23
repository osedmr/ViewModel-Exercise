package com.example.viewmodelexercise.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.example.viewmodelexercise.R
import com.example.viewmodelexercise.databinding.FragmentFirstBinding
import com.example.viewmodelexercise.ui.viewmodel.FragmentSharedViewModel


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
  // private lateinit var viewModel: FragmentSharedViewModel
    private val viewModel: FragmentSharedViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


      //  viewModel = ViewModelProvider(requireActivity()).get(FragmentSharedViewModel::class.java)

        viewModel.lenguage.observe(viewLifecycleOwner, Observer {

            binding.textView.text = it
        })

        if (!viewModel.isRunning){
            viewModel.startTime()
        }


        viewModel.second.observe(viewLifecycleOwner, Observer {
            binding.textCount.text = it.toString()

        })


        binding.save.setOnClickListener {
            viewModel.passLanguageData(binding.editTextText.text.toString())
            val  action = FirstFragmentDirections.actionFirstFragmentToSecondFragment()
            findNavController().navigate(action)
        }

    }


}