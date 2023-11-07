package com.manzurur.later.create

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.*
import androidx.compose.ui.tooling.preview.Preview
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.temporal.ChronoUnit
import java.util.TimeZone
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReminderDatePickerDialog(
    dateTime: LocalDateTime,
    onDateSelected: (LocalDateTime) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState(initialSelectedDateMillis = dateTime.toInstant(
        ZoneOffset.UTC).toEpochMilli())

    DatePickerDialog(
        onDismissRequest = onDismiss,
        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text("Cancel")
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    val selected = datePickerState.selectedDateMillis
                    if (selected == null) {
                        onDismiss()
                    } else {
                        val selectedDate = LocalDateTime.ofEpochSecond(selected / 1000, 0, ZoneOffset.UTC)

                        val updatedDate = dateTime
                            .withYear(selectedDate.year)
                            .with(selectedDate.month)
                            .withDayOfMonth(selectedDate.dayOfMonth)

                        onDateSelected(updatedDate)
                    }
                }
            ) {
                Text("Update")

            }
        }
    ) {
        DatePicker(
            state = datePickerState
        )
    }
}

@Composable @Preview
fun Preview_ReminderDatePickerDialog() {
    ReminderDatePickerDialog(
        dateTime = LocalDateTime.now(),
        onDateSelected = {},
        onDismiss = {}
    )
}

@Composable @Preview
fun Preview_ReminderDatePickerDialog_DifferentMonth() {
    ReminderDatePickerDialog(
        dateTime = LocalDateTime.now().minus(376, ChronoUnit.DAYS),
        onDateSelected = {},
        onDismiss = {}
    )
}