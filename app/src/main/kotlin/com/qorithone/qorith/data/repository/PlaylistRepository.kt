package com.qorithone.qorith.data.repository

import com.qorithone.qorith.data.dao.PlaylistDao
import com.qorithone.qorith.data.model.Playlist
import com.qorithone.qorith.data.model.PlaylistSong
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PlaylistRepository @Inject constructor(
    private val playlistDao: PlaylistDao
) {
    fun getAllPlaylists(): Flow<List<Playlist>> = playlistDao.getAllPlaylists()

    fun getPlaylistById(id: String): Flow<Playlist?> = playlistDao.getPlaylistById(id)

    fun getPlaylistSongIds(playlistId: String): Flow<List<String>> = playlistDao.getPlaylistSongIds(playlistId)

    fun getPlaylistSongCount(playlistId: String): Flow<Int> = playlistDao.getPlaylistSongCount(playlistId)

    suspend fun createPlaylist(name: String): String {
        val id = java.util.UUID.randomUUID().toString()
        val playlist = Playlist(id, name, isSystem = false)
        playlistDao.insertPlaylist(playlist)
        return id
    }

    suspend fun updatePlaylist(playlist: Playlist) = playlistDao.updatePlaylist(playlist)

    suspend fun deletePlaylist(playlist: Playlist) = playlistDao.deletePlaylist(playlist)

    suspend fun addSongToPlaylist(playlistId: String, songId: String, position: Int) {
        val playlistSong = PlaylistSong(playlistId = playlistId, songId = songId, position = position)
        playlistDao.insertPlaylistSong(playlistSong)
    }

    suspend fun removeSongFromPlaylist(playlistId: String, songId: String) =
        playlistDao.removeSongFromPlaylist(playlistId, songId)
}
