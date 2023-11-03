package com.manzurur.later.data

import java.time.Instant

data class Reminder(
    val id: Long,
    val action: ReminderAction,
    val metadata: ReminderMetadata,
    val createdAt: Instant,
    val updatedAt: Instant,
)
