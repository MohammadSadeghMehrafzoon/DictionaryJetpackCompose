package ir.misterdeveloper.mydictionary.presentation.word.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import ir.misterdeveloper.mydictionary.core.Constants.Companion.DELETE_WORD


@Composable
fun DeleteIcon(
    deleteWord: () -> Unit
) {
    IconButton(
        onClick = deleteWord
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = DELETE_WORD,
        )
    }
}