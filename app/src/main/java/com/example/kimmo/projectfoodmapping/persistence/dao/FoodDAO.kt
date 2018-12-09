package com.example.kimmo.projectfoodmapping.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.kimmo.projectfoodmapping.persistence.entities.Food

@Dao
interface FoodDAO {
    @Query("SELECT * FROM food where restaurant_id=:restaurantId")
    fun getAllForRestaurantId(restaurantId: String): List<Food>

    @Insert
    fun insertFood(food: Food)
}