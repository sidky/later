package com.manzurur.later.reminderlist.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksViewModel
import com.manzurur.later.reminderlist.ReminderListViewModel
import com.manzurur.later.ui.theme.LaterTheme

@Composable
fun Reminders() {
    val viewModel: ReminderListViewModel = mavericksViewModel()
    val state by viewModel.collectAsState()

    LaterTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            if (state.isLoading) {
                Text(text = "LOading")
            } else {
                Reminders(sections = state.sections)
            }
        }
    }
}
