package com.manzurur.later.reminderlist

import androidx.lifecycle.ViewModel
import com.airbnb.mvrx.MavericksViewModel

import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.hiltMavericksViewModelFactory
import com.manzurur.later.reminderlist.fakes.SectionsFactory
import dagger.Component
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ReminderListViewModel @AssistedInject constructor(
    @Assisted initialState: ReminderListState
): MavericksViewModel<ReminderListState>(initialState) {

    init {
        suspend {
            loadReminders()
        }.execute {
            copy(isLoading = false, sections = it.invoke() ?: emptyList())
        }
    }

    private suspend fun loadReminders(): List<ReminderSection> {
        val sections = SectionsFactory.sections()

        return sections

//        setState {
//            copy(
//                isLoading = false,
//                sections = sections
//            )
//        }
    }

    @AssistedFactory
    interface Factory: AssistedViewModelFactory<ReminderListViewModel, ReminderListState> {
        override fun create(state: ReminderListState): ReminderListViewModel
    }

    companion object: MavericksViewModelFactory<ReminderListViewModel, ReminderListState>
        by hiltMavericksViewModelFactory()
}