package com.altrodav.friendcircle.db

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.flow.Flow

@Entity
data class FriendEntity(@PrimaryKey val username:String, val name:String, val img:String);

@Dao
interface FriendDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFriend(friendEntity: FriendEntity)

    @Query("SELECT * FROM FriendEntity WHERE username = :username")
    fun getFriendByUsername(username: String): Flow<FriendEntity?>


    @Query("SELECT * FROM FriendEntity")
    fun getAllFriends(): Flow<List<FriendEntity>>

    // It filters by name prefix and sorts result alphabatically

    @Query("""
    SELECT * FROM FriendEntity
    WHERE name LIKE :prefix || '%'
    ORDER BY name ASC
""")
    fun getFriendsByName(prefix: String): Flow<List<FriendEntity>>


}


@Database(entities = [FriendEntity::class], version = 1)
abstract class FriendDatabase : RoomDatabase() {
    abstract fun friendDao(): FriendDao
    companion object{
        fun getDatabase(context: Context): FriendDatabase{
            return Room.databaseBuilder(context.applicationContext,FriendDatabase::class.java,"friend_database").build()
        }
    }
}
