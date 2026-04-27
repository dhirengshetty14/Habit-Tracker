package com.projs.templatesetup.di

import android.content.Context
import androidx.room.Room
import dagger.hilt.components.SingletonComponent

import com.projs.templatesetup.data.local.HabitDao
import com.projs.templatesetup.data.local.HabitDatabase
import com.projs.templatesetup.domian.repository.HabitRepo
import com.projs.templatesetup.domian.repository.IHabitRepo
import com.projs.templatesetup.domian.usecase.AddHabitUseCase
import com.projs.templatesetup.domian.usecase.GetHabitUseCase
import com.projs.templatesetup.domian.usecase.ToggleHabitUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(Singleton::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDB(
        @ApplicationContext context: Context
    ): HabitDatabase {
        return Room.databaseBuilder(
            context,
            HabitDatabase::class.java, "habit_db"
        ).build()
    }

    @Provides
    fun provideDao(db: HabitDatabase): HabitDao {
        return db.habitDao()
    }

    @Provides
    fun provideRepo(
        dao: HabitDao
    ): IHabitRepo {
        return HabitRepo(dao)
    }

    @Provides
    fun provideAddhabitUseCase(
        repo: IHabitRepo
    ) = AddHabitUseCase(repo)

    @Provides
    fun provideGethabitUseCase(
        repo: IHabitRepo
    ) = GetHabitUseCase(repo)

    @Provides
    fun provideTogglehabitUseCase(
        repo: IHabitRepo
    ) = ToggleHabitUseCase(repo)

}