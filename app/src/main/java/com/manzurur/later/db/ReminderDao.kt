package com.manzurur.later.db

import androidx.room.Query

interface ReminderDao {

    @Query("SELECT * FROM reminders")
    suspend fun getAllReminders(): List<ReminderAndAction>
}