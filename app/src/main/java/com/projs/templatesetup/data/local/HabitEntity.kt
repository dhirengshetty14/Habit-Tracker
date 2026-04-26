package com.projs.templatesetup.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habit_table")
data class HabitEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val title: String,
    val isCompleted: Boolean
)