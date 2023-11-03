package com.manzurur.later.reminderlist

import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import dagger.hilt.InstallIn
import com.airbnb.mvrx.hilt.MavericksViewModelComponent
import com.airbnb.mvrx.hilt.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
@InstallIn(MavericksViewModelComponent::class)
interface ReminderListViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ReminderListViewModel::class)
    fun reminderListViewModel(factory: ReminderListViewModel.Factory): AssistedViewModelFactory<*, *>
}