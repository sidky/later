package com.manzurur.later.db

import androidx.room.Embedded
import androidx.room.Relation

data class ReminderAndAction(
    @Embedded
    val reminder: Reminder,

    @Relation(
        parentColumn = "action_id",
        entityColumn = "id"
    )
    val action: ReminderAction
)