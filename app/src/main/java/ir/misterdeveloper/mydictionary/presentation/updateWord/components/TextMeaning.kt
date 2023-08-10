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
fun TextMeaning(meaning: String) {

    Text(
        text = meaning,
        color = Color.Black,
        fontSize = 18.sp,
        modifier = Modifier
            .padding(end = 16.dp)
            .fillMaxWidth(),
        style = MaterialTheme.typography.h2,
        textAlign = TextAlign.End,

        )

}