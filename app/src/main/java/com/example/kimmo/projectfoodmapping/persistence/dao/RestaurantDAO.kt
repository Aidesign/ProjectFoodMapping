package com.example.kimmo.projectfoodmapping.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.kimmo.projectfoodmapping.persistence.entities.Restaurant

@Dao
interface RestaurantDAO {
    @Query("SELECT * FROM restaurant")
    fun getAll(): List<Restaurant>

    @Query("SELECT * FROM restaurant where id=:id")
    fun getRestaurantById(id: String): Restaurant

    @Query("SELECT * FROM restaurant WHERE name=:name and country=:country and city=:city and address=:address")
    fun getRestaurantByNameCountryCityAddress(name: String, country: String, city: String, address: String): Restaurant

    @Insert
    fun addRestaurant(restaurant: Restaurant)
}