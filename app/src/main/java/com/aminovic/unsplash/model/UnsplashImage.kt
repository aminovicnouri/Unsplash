package com.aminovic.unsplash.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aminovic.unsplash.Util.Constants.UNSPLASH_IMAGE_TABLE
import kotlinx.serialization.Serializable


//
// Created by Mohamed El Amine Nouri on 08/10/2022.
// Copyright (c) 2021 Track24. All rights reserved.
//

@Serializable
@Entity(tableName = UNSPLASH_IMAGE_TABLE)
data class UnsplashImage(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    @Embedded
    val urls: Urls,
    val likes: Int,

    @Embedded
    val user: User
)