package ir.misterdeveloper.mydictionary.presentation.updateWord.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import ir.misterdeveloper.mydictionary.core.Constants.Companion.UPDATE_WORD_SCREEN

@Composable
fun UpdateWordTopBar(

    navigateBack: () -> Unit
) {

    TopAppBar (
        title = {
            Text(
                text = UPDATE_WORD_SCREEN
            )
        },
        navigationIcon = {
            IconButton(
                onClick = navigateBack
            ) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = null,
                )
            }
        }
    )
}
