package ir.misterdeveloper.mydictionary.presentation.word.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TextDescription(
    wordDescription: String
) {
    Text(
        text = "by $wordDescription",
        color = Color.DarkGray,
        fontSize = 12.sp,
        textDecoration = TextDecoration.Underline,
        modifier = Modifier.padding(bottom = 8.dp),
        textAlign = TextAlign.Start
    )
}