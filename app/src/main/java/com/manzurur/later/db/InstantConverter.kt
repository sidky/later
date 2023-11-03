package com.manzurur.later.db

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.time.Instant

class InstantConverter {

    @TypeConverter
    fun fromInstant(instant: Instant): Long = instant.toEpochMilli()

    @TypeConverter
    fun toInstant(epochMillis: Long): Instant = Instant.ofEpochMilli(epochMillis)
}