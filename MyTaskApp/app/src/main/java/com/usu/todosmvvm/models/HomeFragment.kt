package com.usu.todosmvvm.models

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.usu.todosmvvm.R
import com.usu.todosmvvm.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            val binding = FragmentHomeBinding.inflate(inflater, container, false)

            binding.toGrocery.setOnClickListener {
                findNavController().navigate(R.id.home_to_grocery)
            }
            binding.toTasks.setOnClickListener{
                findNavController().navigate(R.id.home_to_tasks)
            }
            return binding.root
        }
}