package com.qorithone.qorith.data.di

import android.content.Context
import com.qorithone.qorith.data.dao.SongDao
import com.qorithone.qorith.data.dao.PlaylistDao
import com.qorithone.qorith.data.dao.QueueDao
import com.qorithone.qorith.data.db.QorithDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): QorithDatabase {
        return QorithDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideSongDao(database: QorithDatabase): SongDao = database.songDao()

    @Singleton
    @Provides
    fun providePlaylistDao(database: QorithDatabase): PlaylistDao = database.playlistDao()

    @Singleton
    @Provides
    fun provideQueueDao(database: QorithDatabase): QueueDao = database.queueDao()
}
