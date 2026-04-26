package com.projs.templatesetup.domian.repository

import com.projs.templatesetup.data.local.HabitDao
import com.projs.templatesetup.data.local.HabitEntity
import com.projs.templatesetup.domian.model.Habit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HabitRepo @Inject constructor(
    private val dao: HabitDao
): IHabitRepo {
    override suspend fun addHabit(habit: Habit) {
        dao.insertHabit(
            HabitEntity(
                title = habit.title,
                isCompleted = habit.isCompleted
            )
        )
    }

    override fun getHabits(): Flow<List<Habit>> {
        return dao.getHabits().map {
            list->
            list.map {
                Habit(
                    id =it.id,
                    title = it.title,
                    isCompleted = it.isCompleted
                )
            }
        }
    }

    override suspend fun toggleHabit(id: Int, completed: Boolean) {
        dao.updateHabit(id,completed)
    }
}