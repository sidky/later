package com.manzurur.later.create

import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import java.time.LocalDateTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReminderTimePickerDialog(
    modifier: Modifier = Modifier,
    dateTime: LocalDateTime,
    onTimeUpdated: (updated: LocalDateTime) -> Unit,
    onDismiss: () -> Unit,
) {

    val timePickerState = rememberTimePickerState(
        initialHour = dateTime.hour,
        initialMinute = dateTime.minute
    )

    DatePickerDialog(
        modifier = modifier,
        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text("Cancel")
            }
        },
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {             val updated = dateTime
                .withHour(timePickerState.hour)
                .withMinute(timePickerState.minute)

                onTimeUpdated(updated)
            }) {
                Text(text = "Update")
            }
        }
    ) {
        TimePicker(
            state = timePickerState
        )
    }
}

@Composable @Preview
fun Preview_ReminderTimePickerDialog() {
    ReminderTimePickerDialog(
        dateTime = LocalDateTime.now(),
        onTimeUpdated = { },
        onDismiss = { }
    )
}