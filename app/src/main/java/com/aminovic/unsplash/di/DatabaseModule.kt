package com.aminovic.unsplash.di

import android.content.Context
import androidx.room.Room
import com.aminovic.unsplash.Util.Constants.UNSPLASH_DATABASE
import com.aminovic.unsplash.data.local.UnsplashDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


//
// Created by Mohamed El Amine Nouri on 08/10/2022.
// Copyright (c) 2021 Track24. All rights reserved.
//

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): UnsplashDatabase {
        return Room.databaseBuilder(
            context,
            UnsplashDatabase::class.java,
            UNSPLASH_DATABASE
        ).build()
    }
}