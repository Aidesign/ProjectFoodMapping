package com.example.kimmo.projectfoodmapping

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.time.Instant
import java.util.*

@Entity(tableName = "food")
data class Food (
    @PrimaryKey @ColumnInfo(name = "id") var id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "rating") var rating: Int,
    @ColumnInfo(name = "timestamp") var timestamp: Instant = Instant.now(),
    @ColumnInfo(name = "comment") var comment: String?,
    @ColumnInfo(name = "price") var price: Double,
    @ColumnInfo(name = "type") var type: String
)