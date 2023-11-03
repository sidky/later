package com.manzurur.later.reminderlist.fakes

import com.manzurur.later.data.Reminder
import com.manzurur.later.data.ReminderAction
import com.manzurur.later.data.ReminderMetadata
import com.manzurur.later.reminderlist.ReminderSection
import java.time.Instant
import java.util.concurrent.atomic.AtomicLong

object SectionsFactory {

    private val idGenerator = AtomicLong()

    fun sections() = listOf(
        ReminderSection(
            sectionName = "Needs Attention",
            reminders = listOf(
                reminder(),
                reminder(),
                reminder(),
                reminder(),
                reminder(),
            )
        ),
        ReminderSection(
            sectionName = "Notify at Home",
            reminders = listOf(
                reminder(),
                reminder(),
                reminder(),
                reminder(),
                reminder(),
            )
        ),
        ReminderSection(
            sectionName = "Needs Later",
            reminders = listOf(
                reminder(),
                reminder(),
                reminder(),
                reminder(),
                reminder(),
            )
        ),
        ReminderSection(
            sectionName = "Unprioritized",
            reminders = listOf(
                reminder(),
                reminder(),
                reminder(),
                reminder(),
                reminder(),
            )
        )
    )

    fun reminder(action: ReminderAction = ReminderAction.NoReminderAction) =
        Reminder(
            id = idGenerator.incrementAndGet(),
            action = action,
            metadata = ReminderMetadata(
                title = "Title",
                description = "Description"
            ),
            createdAt = Instant.now(),
            updatedAt = Instant.now(),
        )
}