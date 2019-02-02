package com.example.kimmo.projectfoodmapping.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.kimmo.projectfoodmapping.persistence.entities.FoodType

@Dao
interface FoodTypeDAO {
    @Query("SELECT * FROM foodType" )
    fun getAll(): List<FoodType>

    @Query("SELECT * FROM foodType where id=:id")
    fun getFoodTypeByFoodId(id: String): FoodType

    @Insert
    fun insertFoodType(foodType: FoodType)
}