package com.qorithone.qorith.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.qorithone.qorith.data.model.QueueItem
import kotlinx.coroutines.flow.Flow

@Dao
interface QueueDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: QueueItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<QueueItem>)

    @Delete
    suspend fun delete(item: QueueItem)

    @Query("SELECT * FROM queue ORDER BY position ASC")
    fun getQueue(): Flow<List<QueueItem>>

    @Query("SELECT songId FROM queue ORDER BY position ASC")
    fun getQueueSongIds(): Flow<List<String>>

    @Query("DELETE FROM queue")
    suspend fun clear()

    @Query("UPDATE queue SET position = :newPosition WHERE id = :id")
    suspend fun updatePosition(id: Int, newPosition: Int)
}
