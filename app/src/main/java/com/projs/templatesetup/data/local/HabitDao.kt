package com.projs.templatesetup.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHabit(
        habit: HabitEntity
    )

    @Query("SELECT * FROM habit_table")
    fun getHabits(): Flow<List<HabitEntity>>

    @Query("""
        UPDATE habit_table
        SET isCompleted = :completed
        WHERE id = :id
    """)
    suspend fun updateHabit(
        id: Int,
        completed: Boolean
    )
}