package com.qorithone.qorith.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.qorithone.qorith.data.model.Song
import kotlinx.coroutines.flow.Flow

@Dao
interface SongDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(song: Song)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(songs: List<Song>)

    @Update
    suspend fun update(song: Song)

    @Delete
    suspend fun delete(song: Song)

    @Query("SELECT * FROM songs ORDER BY title ASC")
    fun getAllSongs(): Flow<List<Song>>

    @Query("SELECT * FROM songs WHERE id = :id")
    fun getSongById(id: String): Flow<Song?>

    @Query("SELECT * FROM songs WHERE folder = :folder ORDER BY title ASC")
    fun getSongsByFolder(folder: String): Flow<List<Song>>

    @Query("SELECT DISTINCT folder FROM songs ORDER BY folder ASC")
    fun getAllFolders(): Flow<List<String>>

    @Query("SELECT * FROM songs WHERE isFavorite = 1 ORDER BY title ASC")
    fun getFavoriteSongs(): Flow<List<Song>>

    @Query("UPDATE songs SET isFavorite = :isFavorite WHERE id = :songId")
    suspend fun updateFavorite(songId: String, isFavorite: Boolean)

    @Query("UPDATE songs SET playCount = playCount + 1, lastPlayed = :timestamp WHERE id = :songId")
    suspend fun incrementPlayCount(songId: String, timestamp: Long)

    @Query("SELECT * FROM songs WHERE title LIKE :query OR artist LIKE :query ORDER BY title ASC")
    fun searchSongs(query: String): Flow<List<Song>>

    @Query("DELETE FROM songs")
    suspend fun deleteAll()
}
