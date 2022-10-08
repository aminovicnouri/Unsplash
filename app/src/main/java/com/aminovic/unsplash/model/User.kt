package com.aminovic.unsplash.model

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class User(

    @Embedded
    val links: UserLinks,

    val username: String,
)
