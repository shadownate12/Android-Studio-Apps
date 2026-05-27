package com.usu.todosmvvm.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo var description: String,
    @ColumnInfo var completed: Boolean
)