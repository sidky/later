package com.manzurur.later.db

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.LocalDateTime

@Entity(tableName = "reminder_action")
data class ReminderAction(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val actionId: Long,

    @ColumnInfo(name = "action_type")
    val actionType: ActionType,

    @ColumnInfo(name = "name")
    val name: String? = null,

    @Embedded
    val geoFencedArea: GeoFenceArea? = null,

    @ColumnInfo(name = "scheduled_at")
    val scheduledAt: LocalDateTime? = null,

    @ColumnInfo(name = "created_at")
    val createdAt: Instant,

    @ColumnInfo(name = "updated_at")
    val updatedAt: Instant
)