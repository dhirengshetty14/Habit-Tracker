package com.projs.templatesetup.domian.repository

import com.projs.templatesetup.domian.model.Habit
import kotlinx.coroutines.flow.Flow

interface IHabitRepo {

    suspend fun addHabit(habit: Habit)
    fun getHabits(): Flow<List<Habit>>
    suspend fun toggleHabit(id: Int, completed: Boolean)
}