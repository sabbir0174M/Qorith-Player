package com.qorithone.qorith.data.repository

import com.qorithone.qorith.data.dao.QueueDao
import com.qorithone.qorith.data.model.QueueItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class QueueRepository @Inject constructor(
    private val queueDao: QueueDao
) {
    fun getQueue(): Flow<List<QueueItem>> = queueDao.getQueue()

    fun getQueueSongIds(): Flow<List<String>> = queueDao.getQueueSongIds()

    suspend fun addToQueue(songId: String, position: Int) {
        val item = QueueItem(songId = songId, position = position)
        queueDao.insert(item)
    }

    suspend fun addMultipleToQueue(songIds: List<String>) {
        val items = songIds.mapIndexed { index, songId ->
            QueueItem(songId = songId, position = index)
        }
        queueDao.insertAll(items)
    }

    suspend fun clearQueue() = queueDao.clear()

    suspend fun updateQueueOrder(queue: List<String>) {
        queueDao.clear()
        queue.forEachIndexed { index, songId ->
            queueDao.insert(QueueItem(songId = songId, position = index))
        }
    }
}
