package com.manzurur.later.data

import java.time.LocalDateTime

sealed interface ReminderAction {

    class ScheduledAction(val localDateTime: LocalDateTime): ReminderAction

    class GeoFencedAction(val reminderArea: ReminderArea): ReminderAction

    data object NoReminderAction: ReminderAction
}