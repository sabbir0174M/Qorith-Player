package com.qorithone.qorith.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "queue")
data class QueueItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val songId: String,
    val position: Int,
    val dateAdded: Long = System.currentTimeMillis()
)

data class PlaybackState(
    val currentSongId: String? = null,
    val isPlaying: Boolean = false,
    val position: Long = 0L,
    val shuffle: Boolean = false,
    val repeat: RepeatMode = RepeatMode.OFF
)

enum class RepeatMode {
    OFF, ONE, ALL
}
