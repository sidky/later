package com.manzurur.later.create

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.manzurur.later.ui.theme.LaterTheme
import timber.log.Timber
import java.time.LocalDateTime

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReminderEditor(
    modifier: Modifier = Modifier,
    title: String = "Create",
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(title) },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(top = it.calculateTopPadding(), bottom = it.calculateBottomPadding(), start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextField(value = "FooBar", onValueChange = {}, label = { Text("Title")})
            TextField(value = "(Optional)", onValueChange = {}, label = { Text("URL")})
            ScheduleReminder(dateTime = LocalDateTime.now(), onDateTimeChange = { Timber.e(it.toString())})
//            Text(text = "Remind me at", fontWeight = FontWeight.Bold)
//            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(16.dp)) {
//                Icon(imageVector = Icons.Default.CalendarToday, contentDescription = null)
//                TextField(modifier = Modifier.weight(1.0f), value = "mm/dd/yyyy", onValueChange = {}, label = { Text("Reminder date")})
//            }
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Icon(imageVector = Icons.Default.AccessTime, contentDescription = null)
                TextField(modifier = Modifier.weight(1.0f), value = "hh:mm", onValueChange = {}, label = { Text("Reminder time")})
            }
        }
    }
}

@Composable @Preview
fun Preview_ReminderEditor() {
    LaterTheme {
        ReminderEditor(modifier = Modifier.fillMaxSize())
    }
}