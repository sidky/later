package com.manzurur.later.reminderlist.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.mvrx.Mavericks
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksViewModel
import com.manzurur.later.reminderlist.ReminderListViewModel
import com.manzurur.later.ui.theme.LaterTheme

@Composable
fun ReminderList() {
    val viewModel: ReminderListViewModel = mavericksViewModel()
    val state by viewModel.collectAsState()

    LaterTheme {
        Scaffold(
            topBar = {},
            bottomBar = {},
            floatingActionButton = {
                FloatingActionButton(onClick = { /*TODO*/ }, shape = CircleShape) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }
            }
        ) {
            Surface(modifier = Modifier.padding(it)) {
                if (state.isLoading) {
                    Text(text = "Loading")
                } else {
                    ReminderList(sections = state.sections)
                }
            }
        }
    }
}
