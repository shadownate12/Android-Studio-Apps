package com.usu.todosmvvm

import androidx.room.*
import com.usu.todosmvvm.models.Todo

@Dao
interface TodosDao {
    @Query("SELECT * FROM todo")
    suspend fun getAllTodos(): List<Todo>

    @Insert
    suspend fun createTodo(todo: Todo): Long

    @Update
    suspend fun updateTodo(todo: Todo)

    @Delete
    suspend fun removeTodo(todo : Todo)



//    @Insert
//    suspend fun createMany(vararg todos: List<Todo>)
}