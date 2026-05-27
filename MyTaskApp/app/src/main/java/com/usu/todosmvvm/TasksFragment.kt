package com.usu.todosmvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.usu.todosmvvm.databinding.FragmentTasksBinding
import com.usu.todosmvvm.databinding.FragmentTodosBinding

class TasksFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentTasksBinding.inflate(inflater, container, false)
        val viewModel2 = TodosViewModel2()

        binding.todosList.adapter = TodosAdapter(viewModel2.todos) {
            viewModel2.toggleTodoCompletion(it)
        }
        binding.todosList.layoutManager = LinearLayoutManager(context)
        viewModel2.errorMessage.observe(viewLifecycleOwner) {errorMessage ->
            binding.errorOutput.text = errorMessage
        }
        binding.saveButton.setOnClickListener {
            viewModel2.createTodo(binding.todoInput.text.toString())
            binding.todoInput.setText("")
        }
        binding.tasksToHome.setOnClickListener{
            findNavController().navigate(R.id.tasks_to_home)
        }
        binding.removeButton2.setOnClickListener {
            viewModel2.removeTodo()
        }
        return binding.root
    }
}