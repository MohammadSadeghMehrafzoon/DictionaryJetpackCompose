package ir.misterdeveloper.mydictionary.presentation.word.components



import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import ir.misterdeveloper.mydictionary.core.Constants.Companion.WORD_SCREEN


@Composable
fun WordTopBar() {

    TopAppBar(title = { Text(text = WORD_SCREEN) })
}