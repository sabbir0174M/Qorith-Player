package com.qorithone.qorith.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "songs")
data class Song(
    @PrimaryKey
    val id: String,
    val title: String,
    val artist: String = "",
    val album: String = "",
    val folder: String,
    val path: String,
    val duration: Long,
    val fileSize: Long,
    val isFavorite: Boolean = false,
    val playCount: Int = 0,
    val lastPlayed: Long = 0L,
    val dateAdded: Long = System.currentTimeMillis()
)
