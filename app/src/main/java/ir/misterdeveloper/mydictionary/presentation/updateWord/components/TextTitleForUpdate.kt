package ir.misterdeveloper.mydictionary.presentation.updateWord.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TextTitleForUpdate(wordTitle: String) {

    Text(
        text = wordTitle,
        color = Color.DarkGray,
        fontSize = 14.sp,
        modifier = Modifier.padding(start = 16.dp).fillMaxWidth(),
        style = MaterialTheme.typography.h2,
        textAlign = TextAlign.Start,

        )
}