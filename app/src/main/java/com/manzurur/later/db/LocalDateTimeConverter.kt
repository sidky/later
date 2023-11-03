package com.manzurur.later.db

import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

class LocalDateTimeConverter {

    @TypeConverter
    fun fromLocalDateTime(ldt: LocalDateTime): Long = ldt.toInstant(ZoneOffset.UTC).toEpochMilli()

    @TypeConverter
    fun toLocalDateTime(epochMillis: Long): LocalDateTime =
        LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMillis), ZoneOffset.UTC)
}