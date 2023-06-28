package com.example.workercontroller.date

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.workercontroller.date.DatasDatabase.Companion.DATABASE_NAME

@Entity(tableName = DATABASE_NAME)
data class DatasEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int = DEFAULT_VALUE,
    val someDAta: String = DEFAULT_VALUE_STRING
) {
    private companion object {
        const val DEFAULT_VALUE = -1
        const val DEFAULT_VALUE_STRING = ""
    }
}
