package com.manzurur.later.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [
        Reminder::class
    ],
    version = 1
)
@TypeConverters(
    InstantConverter::class,
    LocalDateTimeConverter::class,
)
abstract class ReminderDatabase: RoomDatabase() {

    abstract fun remindersDao(): ReminderDao
}