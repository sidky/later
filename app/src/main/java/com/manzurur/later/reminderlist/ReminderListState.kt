package com.manzurur.later.reminderlist

import com.airbnb.mvrx.MavericksState

data class ReminderListState(
    val isLoading: Boolean = true,
    val sections: List<ReminderSection> = emptyList(),
): MavericksState
