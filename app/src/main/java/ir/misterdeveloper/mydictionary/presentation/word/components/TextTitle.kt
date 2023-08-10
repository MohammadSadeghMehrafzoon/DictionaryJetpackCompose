package ir.misterdeveloper.mydictionary.presentation.word.components

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
fun TextTitle(wordTitle: String) {

    Text(
        text = wordTitle,
        color = Color.Black,
        fontSize = 18.sp,
        modifier = Modifier.padding(start = 16.dp, top = 4.dp, bottom = 4.dp),
        style = MaterialTheme.typography.h2,
        textAlign = TextAlign.Center
    )
}