package com.altrodav.friendcircle.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProfileDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProfile(profileEntity: ProfileEntity)

    @Query("SELECT * FROM ProfileEntity WHERE id = :id")
    suspend fun getProfileById(id: Int): ProfileEntity?
}
