package com.manzurur.later.db

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant

@Entity(tableName = "reminders")
data class Reminder(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long,

    @ColumnInfo(name = "action_id")
    val actionId: Long,

    @Embedded
    val metadata: ReminderMetadata,

    @ColumnInfo(name = "created_at")
    val createdAt: Instant,

    @ColumnInfo(name = "updated_at")
    val updatedAt: Instant,

    @ColumnInfo(name = "status")
    val status: ReminderStatus
)