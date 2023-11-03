package com.manzurur.later.reminderlist.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.manzurur.later.data.Reminder
import com.manzurur.later.data.ReminderAction
import com.manzurur.later.data.ReminderMetadata
import java.time.Instant

@Composable
fun ReminderItem(modifier: Modifier, reminder: Reminder) {
    Card(modifier = modifier) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = reminder.metadata.title
        )
    }
}

@Composable @Preview
fun Preview_ReminderItem() {
    ReminderItem(
        modifier = Modifier
            .width(200.dp)
            .height(200.dp),
        reminder = Reminder(
            id = 1,
            action = ReminderAction.NoReminderAction,
            metadata = ReminderMetadata(title = "Foo", description = "bar"),
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    )
}