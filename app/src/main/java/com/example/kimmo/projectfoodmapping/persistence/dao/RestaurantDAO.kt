package com.example.kimmo.projectfoodmapping.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.kimmo.projectfoodmapping.persistence.entities.Restaurant

@Dao
interface RestaurantDAO {
    @Query("SELECT * FROM restaurant")
    fun getAll(): List<Restaurant>

    @Insert
    fun addRestaurant(restaurant: Restaurant)
}