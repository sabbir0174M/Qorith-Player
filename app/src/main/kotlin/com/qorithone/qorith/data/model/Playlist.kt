package com.qorithone.qorith.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "playlists")
data class Playlist(
    @PrimaryKey
    val id: String,
    val name: String,
    val isSystem: Boolean = false,
    val dateCreated: Long = System.currentTimeMillis(),
    val dateModified: Long = System.currentTimeMillis()
)

@Entity(tableName = "playlist_songs")
data class PlaylistSong(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val playlistId: String,
    val songId: String,
    val position: Int
)
