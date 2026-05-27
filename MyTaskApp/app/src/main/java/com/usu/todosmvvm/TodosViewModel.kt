package com.usu.todosmvvm

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.usu.todosmvvm.models.Todo
import kotlinx.coroutines.*

var idCounter = 0

class TodosViewModel: ViewModel() {
    val todos = ObservableArrayList<Todo>()
    val errorMessage = MutableLiveData("")
    var output = "";

    init {
        loadTodos()
    }

    private fun loadTodos() {
        viewModelScope.launch {
            val loadedTodos = TodosRepository.getAllTodos()
            todos.addAll(loadedTodos)
        }
    }

    fun toggleTodoCompletion(todo: Todo) {
        viewModelScope.launch {
            todo.completed = !todo.completed
            TodosRepository.update(todo)
            todos[todos.indexOf(todo)] = todo.copy()
        }
    }

    fun createTodo(todoInput: String) {
        errorMessage.value = ""
        if (todoInput.isEmpty()) {
            errorMessage.value = "Todo input cannot be blank."
            viewModelScope.launch {
                delay(3000)
                errorMessage.value = ""
            }
            return
        }
        if(todoInput.trim().isEmpty()) {
            errorMessage.value = "Todo input must contain at least one alpha numerica character"
            return
        }

        // create todo
        viewModelScope.launch {
            val todo = Todo(id = 0, description = todoInput, completed = false)
            todo.id = TodosRepository.createTodo(todo).toInt();
            todos.add(todo)
        }
    }

    fun removeTodo(){
        if(todos.isEmpty()){
            errorMessage.value = "No Todos to delete."
            viewModelScope.launch {
                delay(3000)
                errorMessage.value = ""
            }
            return
        }
        //Remove Todo
        viewModelScope.launch {
            TodosRepository.remove(todos[0])
            todos.removeFirst()
        }

    }

}