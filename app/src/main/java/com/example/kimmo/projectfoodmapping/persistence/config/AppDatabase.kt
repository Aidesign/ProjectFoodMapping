package com.example.kimmo.projectfoodmapping.persistence.config

import android.arch.persistence.room.*
import android.content.Context
import com.example.kimmo.projectfoodmapping.persistence.dao.FoodDAO
import com.example.kimmo.projectfoodmapping.persistence.entities.Food

@Database(entities = arrayOf(Food::class), version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun foodDAO(): FoodDAO

    companion object {
        @Volatile
                private var INSTANCE: AppDatabase? = null

                fun getDatabase(context: Context): AppDatabase {
                    val tempInstance = INSTANCE
                    if(tempInstance != null) {
                        return tempInstance
                    }
                    synchronized(this) {
                        val instance = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "App_database").allowMainThreadQueries().build()
                        INSTANCE = instance
                return instance
            }
        }
    }
}