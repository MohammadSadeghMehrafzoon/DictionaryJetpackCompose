package ir.misterdeveloper.mydictionary.presentation.updateWord
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import ir.misterdeveloper.mydictionary.presentation.updateWord.components.UpdateWordContent
import ir.misterdeveloper.mydictionary.presentation.updateWord.components.UpdateWordTopBar
import ir.misterdeveloper.mydictionary.presentation.word.WordViewModel


@Composable
fun UpdateWordScreen(

    viewModel: WordViewModel = hiltViewModel(),
    wordId: Int,
    navigateBack: () -> Unit

) {

    LaunchedEffect(Unit) {
        viewModel.getWord(wordId)
    }

    Scaffold(
        topBar = { UpdateWordTopBar(navigateBack = navigateBack) },
        content = { padding ->
            UpdateWordContent(
                padding,
                word = viewModel.wordMutable,
                navigateBack = navigateBack
            )
        }
    )

}