package com.altrodav.friendcircle.db

import androidx.room.Entity
import androidx.room.PrimaryKey

// This file contains code for table/entity Profile

@Entity
data class ProfileEntity(
    @PrimaryKey val id: Int = 0,
    val name: String,
    val bio: String,
    val img: String?

)