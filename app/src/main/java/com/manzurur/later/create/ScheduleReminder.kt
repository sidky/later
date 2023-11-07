package com.manzurur.later.create

import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleReminder(
    modifier: Modifier = Modifier,
    dateTime: LocalDateTime,
    title: String = "Remind at",
    onDateTimeChange: (updatedTime: LocalDateTime) -> Unit,
) {
    val dateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
    val timeFormat = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)

    var showDatePicker by remember { mutableStateOf(false) }
    var showTimePicker by remember { mutableStateOf(false) }

    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        RuleHeader(headerText = title)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    showDatePicker = !showDatePicker
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Icon(imageVector = Icons.Default.Alarm, contentDescription = null)
            Text(
                modifier = Modifier
                    .clickable {
                               showDatePicker = true
                    },
                text = dateFormat.format(dateTime)
            )
            Spacer(modifier = Modifier.weight(1.0f))
            Text(
                modifier = Modifier
                    .clickable {
                        showTimePicker = true
                    },
                text = timeFormat.format(dateTime)
            )

            if (showDatePicker) {
                ReminderDatePickerDialog(dateTime = LocalDateTime.now(), onDateSelected = {}) {
                    showDatePicker = false
                }
            }

            if (showTimePicker) {
                ReminderTimePickerDialog(dateTime = LocalDateTime.now(), onTimeUpdated = {}) {
                    showTimePicker = false
                }
            }
        }
    }
}

@Composable @Preview
fun Preview_ScheduleReminder() {
    ScheduleReminder(dateTime = LocalDateTime.now(), onDateTimeChange = {})
}