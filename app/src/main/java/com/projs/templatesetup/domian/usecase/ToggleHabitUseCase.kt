package com.projs.templatesetup.domian.usecase

import com.projs.templatesetup.domian.repository.IHabitRepo

class ToggleHabitUseCase(private val repo: IHabitRepo) {
    suspend operator fun invoke(id: Int, completed: Boolean){
        repo.toggleHabit(id, completed)
    }
}