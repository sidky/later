package com.manzurur.later.db

import androidx.room.ColumnInfo

data class ReminderMetadata(

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "url")
    val url: String? = null,

    @ColumnInfo(name = "thumbnail")
    val thumbnailUrl: String? = null
)