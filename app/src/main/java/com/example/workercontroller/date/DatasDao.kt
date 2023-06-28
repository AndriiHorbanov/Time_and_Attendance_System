package com.example.workercontroller.date

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DatasDao {



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addData(data: DatasEntity)

    @Query("SELECT * FROM data_table ORDER BY id ASC")
    fun readAll(): Flow<List<DatasEntity>>

    @Delete
    suspend fun deleteDatas(data: DatasEntity)
}