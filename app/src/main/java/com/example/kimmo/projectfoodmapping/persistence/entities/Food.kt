package com.example.kimmo.projectfoodmapping.persistence.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import java.time.Instant
import java.util.*

@Entity(tableName = "food",
        foreignKeys = arrayOf(ForeignKey(
            entity = Restaurant::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("restaurant_id")
        )
    )
)
data class Food (
    @PrimaryKey @ColumnInfo(name = "id") var id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "rating") var rating: Int,
    @ColumnInfo(name = "timestamp") var timestamp: Instant = Instant.now(),
    @ColumnInfo(name = "comment") var comment: String?,
    @ColumnInfo(name = "price") var price: Double,
    @ColumnInfo(name = "type") var type: String,
    @ColumnInfo(name = "restaurant_id") var restaurantId: String
)