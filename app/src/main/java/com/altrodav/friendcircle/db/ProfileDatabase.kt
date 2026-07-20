package com.altrodav.friendcircle.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ProfileEntity::class], version = 1)
abstract class ProfileDatabase : RoomDatabase() {
    abstract fun profileDao(): ProfileDao
    companion object{
        fun getDatabase(context: Context): ProfileDatabase{
            return Room.databaseBuilder(context.applicationContext,ProfileDatabase::class.java,"profile_database").build()
        }
    }
}