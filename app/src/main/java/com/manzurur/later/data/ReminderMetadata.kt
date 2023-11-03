package com.manzurur.later.data

data class ReminderMetadata(
    val title: String,
    val description: String,
    val url: String? = null,
    val thumbnailUrl: String? = null,
)
