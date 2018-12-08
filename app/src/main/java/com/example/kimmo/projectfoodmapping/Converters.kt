package com.example.kimmo.projectfoodmapping

import android.arch.persistence.room.TypeConverter
import java.time.Instant
import java.time.ZonedDateTime

class Converters {
    companion object {
        @TypeConverter
        @JvmStatic
        fun fromInstant(value: Instant): Long {
            return value.toEpochMilli()
        }

        @TypeConverter
        @JvmStatic
        fun toInstant(value: Long): Instant {
            return Instant.ofEpochMilli(value)
        }
    }

}