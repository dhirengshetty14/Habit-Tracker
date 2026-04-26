package com.projs.templatesetup.data.local

import androidx.room.Database

@Database(entities = [HabitEntity::class], version = 1)
abstract class HabitDatabase {
    abstract fun habitDao(): HabitDao
}