package com.example.workercontroller.date

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DatasEntity::class], version = 1, exportSchema = false)
abstract class DatasDatabase : RoomDatabase() {
    abstract fun datasDao(): DatasDao

    companion object {
        const val DATABASE_NAME = "data_table"

        @Volatile
        private var INSTANCE: DatasDatabase? = null
        fun getDatabase(context: Context): DatasDatabase {
            val templateInstance = INSTANCE
            if (templateInstance != null) {
                return templateInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatasDatabase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}