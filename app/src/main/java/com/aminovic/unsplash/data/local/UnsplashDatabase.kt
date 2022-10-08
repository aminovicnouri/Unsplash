package com.aminovic.unsplash.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aminovic.unsplash.data.local.dao.UnsplashImageDao
import com.aminovic.unsplash.data.local.dao.UnsplashRemoteKeysDao
import com.aminovic.unsplash.model.UnsplashImage
import com.aminovic.unsplash.model.UnsplashRemoteKeys


//
// Created by Mohamed El Amine Nouri on 08/10/2022.
// Copyright (c) 2021 Track24. All rights reserved.
//

@Database(entities = [UnsplashImage::class, UnsplashRemoteKeys::class], version = 1)
abstract class UnsplashDatabase: RoomDatabase() {

    abstract fun unsplashImageDao(): UnsplashImageDao
    abstract fun unsplashRemoteKeysDao(): UnsplashRemoteKeysDao

}