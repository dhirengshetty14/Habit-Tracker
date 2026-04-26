package com.projs.templatesetup.domian.usecase

import com.projs.templatesetup.domian.model.Habit
import com.projs.templatesetup.domian.repository.IHabitRepo

class AddHabitUseCase(private val repo: IHabitRepo) {
    suspend operator fun invoke(habit: Habit){
        repo.addHabit(habit)
    }
}