package com.high_thon.lucian.data

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.high_thon.lucian.data.local.DiaryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {

    @Singleton
    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun provideDatabase(
        context: Context
    ): AppDataBase = AppDataBase.create(context)

    @Singleton
    @Provides
    fun provideDiaryDao(
        database: AppDataBase
    ): DiaryDao = database.diaryDao()
}