package com.qorithone.qorith.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.qorithone.qorith.data.dao.SongDao
import com.qorithone.qorith.data.dao.PlaylistDao
import com.qorithone.qorith.data.dao.QueueDao
import com.qorithone.qorith.data.model.Song
import com.qorithone.qorith.data.model.Playlist
import com.qorithone.qorith.data.model.PlaylistSong
import com.qorithone.qorith.data.model.QueueItem

@Database(
    entities = [
        Song::class,
        Playlist::class,
        PlaylistSong::class,
        QueueItem::class
    ],
    version = 1,
    exportSchema = false
)
abstract class QorithDatabase : RoomDatabase() {
    abstract fun songDao(): SongDao
    abstract fun playlistDao(): PlaylistDao
    abstract fun queueDao(): QueueDao

    companion object {
        @Volatile
        private var instance: QorithDatabase? = null

        fun getInstance(context: Context): QorithDatabase {
            return instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    QorithDatabase::class.java,
                    "qorith_database"
                ).build().also { instance = it }
            }
        }
    }
}
