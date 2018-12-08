package com.example.kimmo.projectfoodmapping

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface FoodDAO {
    @Query("SELECT * FROM food")
    fun getAll(): List<Food>

    @Insert
    fun insertFood(food: Food)
}