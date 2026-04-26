package com.projs.templatesetup.domian.usecase

import com.projs.templatesetup.domian.model.Habit
import com.projs.templatesetup.domian.repository.IHabitRepo
import kotlinx.coroutines.flow.Flow

class GetHabitUseCase(
    private val repo: IHabitRepo
) {
    operator fun invoke(): Flow<List<Habit>> {
        return repo.getHabits()
    }
}