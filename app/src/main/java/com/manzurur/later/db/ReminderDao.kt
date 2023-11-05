package com.manzurur.later.db

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface ReminderDao {

    @Transaction
    @Query("SELECT * FROM reminders")
    suspend fun getAllReminders(): List<ReminderAndAction>
}