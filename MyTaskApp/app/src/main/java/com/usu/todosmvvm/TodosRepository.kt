package com.usu.todosmvvm

import androidx.room.Room
import androidx.room.RoomDatabase
import com.usu.todosmvvm.models.Todo

object TodosRepository {
    private val db: AppDatabase;
    init {
        db = Room.databaseBuilder(
            TodosApplication.getInstance(),
            AppDatabase::class.java,
            "todos-database"
        ).build()
    }

    suspend fun createTodo(todo: Todo): Long {
        return db.getTodosDao().createTodo(todo)
    }

    suspend fun getAllTodos(): List<Todo> {
        return db.getTodosDao().getAllTodos()
    }

    suspend fun update(todo: Todo) {
        db.getTodosDao().updateTodo(todo)
    }
    suspend fun remove(todo : Todo){
        db.getTodosDao().removeTodo(todo)
    }

}

object TodosRepository2 {
    private val db2: AppDatabase;
    init {
        db2 = Room.databaseBuilder(
            TodosApplication.getInstance(),
            AppDatabase::class.java,
            "todos-database2"
        ).build()
    }

    suspend fun createTodo(todo: Todo): Long {
        return db2.getTodosDao().createTodo(todo)
    }

    suspend fun getAllTodos(): List<Todo> {
        return db2.getTodosDao().getAllTodos()
    }

    suspend fun update(todo: Todo) {
        db2.getTodosDao().updateTodo(todo)
    }
    suspend fun remove(todo : Todo){
        db2.getTodosDao().removeTodo(todo)
    }


}
