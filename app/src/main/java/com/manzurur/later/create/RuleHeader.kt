package com.manzurur.later.create

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun RuleHeader(
    modifier: Modifier = Modifier,
    headerText: String) {

    Text(
        modifier = modifier,
        text = headerText,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )
    
}

@Composable @Preview
fun Preview_RuleHeader() {
    RuleHeader(headerText = "Remind at")
}