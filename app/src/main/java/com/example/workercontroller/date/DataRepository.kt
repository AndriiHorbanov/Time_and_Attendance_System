package com.example.workercontroller.date

import kotlinx.coroutines.flow.Flow

class DataRepository(private val dataDao: DatasDao) {
    fun readAllData(): Flow<List<DatasEntity>> = dataDao.readAll()

    suspend fun addDatas(data: DatasEntity){
        dataDao.addData(data)
    }

    suspend fun  deleteDatas(data: DatasEntity){
        dataDao.deleteDatas(data)
    }
}