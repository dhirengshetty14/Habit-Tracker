package com.projs.templatesetup.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.projs.templatesetup.domian.model.Habit
import com.projs.templatesetup.domian.usecase.AddHabitUseCase
import com.projs.templatesetup.domian.usecase.GetHabitUseCase
import com.projs.templatesetup.domian.usecase.ToggleHabitUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HabitViewModel @Inject constructor(
    private val addHabitUseCase: AddHabitUseCase,
    private val getHabitUseCase: GetHabitUseCase,
    private val toggleHabitUseCase: ToggleHabitUseCase
): ViewModel() {

    val habits= getHabitUseCase()
        .stateIn(viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    fun addHabit(title: String){
        viewModelScope.launch {
            addHabitUseCase(
                Habit(title = title, isCompleted = false)
            )
        }
    }

    fun toggleHabit(habit: Habit){
        viewModelScope.launch {
            toggleHabitUseCase(
                habit.id,
                !habit.isCompleted
            )
        }
    }

}