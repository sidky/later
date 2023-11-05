package com.manzurur.later.reminderlist.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.manzurur.later.reminderlist.ReminderSection
import com.manzurur.later.reminderlist.fakes.SectionsFactory

@Composable
fun ReminderList(
    modifier: Modifier = Modifier,
    sections: List<ReminderSection>,
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        sections.forEach { section ->
            item(span = { GridItemSpan(this.maxLineSpan) }) {
                Text(
                    modifier = Modifier.padding(vertical = 5.dp),
                    text = section.sectionName,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            items(section.reminders) {
                ReminderItem(modifier = Modifier.size(200.dp), reminder = it)
            }
        }
    }

}


@Composable @Preview
fun Preview_Reminders() {
    ReminderList(sections = SectionsFactory.sections())
}