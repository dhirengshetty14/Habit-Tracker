package com.projs.templatesetup.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.projs.templatesetup.data.local.HabitEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao {
    @Insert
    suspend fun insertHabit(habit: HabitEntity)

    @Query("select * from habit_table")
    fun getHabits(): Flow<List<HabitEntity>>

    @Query("update habit_table set isCompleted = :completed where id = :id")
    suspend fun updateHabit(id: Int, completed: Boolean)
}