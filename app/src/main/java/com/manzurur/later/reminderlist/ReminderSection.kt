package com.manzurur.later.reminderlist

import com.manzurur.later.data.Reminder

data class ReminderSection(
    val sectionName: String,
    val reminders: List<Reminder>
)