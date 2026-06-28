package com.qorithone.qorith.data.repository

import com.qorithone.qorith.data.dao.SongDao
import com.qorithone.qorith.data.model.Song
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SongRepository @Inject constructor(
    private val songDao: SongDao
) {
    fun getAllSongs(): Flow<List<Song>> = songDao.getAllSongs()

    fun getSongById(id: String): Flow<Song?> = songDao.getSongById(id)

    fun getSongsByFolder(folder: String): Flow<List<Song>> = songDao.getSongsByFolder(folder)

    fun getAllFolders(): Flow<List<String>> = songDao.getAllFolders()

    fun getFavoriteSongs(): Flow<List<Song>> = songDao.getFavoriteSongs()

    fun searchSongs(query: String): Flow<List<Song>> = songDao.searchSongs("%$query%")

    suspend fun insertSong(song: Song) = songDao.insert(song)

    suspend fun insertAllSongs(songs: List<Song>) = songDao.insertAll(songs)

    suspend fun updateFavorite(songId: String, isFavorite: Boolean) = songDao.updateFavorite(songId, isFavorite)

    suspend fun incrementPlayCount(songId: String) = songDao.incrementPlayCount(songId, System.currentTimeMillis())

    suspend fun deleteAll() = songDao.deleteAll()
}
