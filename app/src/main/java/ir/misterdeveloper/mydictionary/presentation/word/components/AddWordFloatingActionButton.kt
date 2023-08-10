package ir.misterdeveloper.mydictionary.presentation.word.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable

@Composable
fun AddWordFloatingActionButton(
    openDialog: () -> Unit,
    text: String
) {

    ExtendedFloatingActionButton(
        onClick = openDialog,
        backgroundColor = MaterialTheme.colors.primary,
        icon = {
            Icon(
                Icons.Filled.Add, contentDescription = ""
            )
        },
        text = { Text(text = text) })


}