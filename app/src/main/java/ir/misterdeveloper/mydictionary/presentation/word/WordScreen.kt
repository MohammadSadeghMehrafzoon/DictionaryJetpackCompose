package ir.misterdeveloper.mydictionary.presentation.word

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.platform.LocalContext
import ir.misterdeveloper.mydictionary.core.Constants.Companion.TEXT_ADD_ACTION_BUTTON
import ir.misterdeveloper.mydictionary.presentation.word.components.AddWordAlertDialog
import ir.misterdeveloper.mydictionary.presentation.word.components.AddWordFloatingActionButton
import ir.misterdeveloper.mydictionary.presentation.word.components.WordContent
import ir.misterdeveloper.mydictionary.presentation.word.components.WordTopBar


@Composable
@ExperimentalMaterialApi
fun WordScreen(
    viewModel: WordViewModel = hiltViewModel(),
    navigateToUpdateWordScreen: (wordId: Int) -> Unit
) {


    val word by viewModel.word.collectAsState(
        initial = emptyList()
    )

    Scaffold(
        topBar = {
            WordTopBar()
        },
        content = { padding ->
            WordContent(
                padding = padding,
                words = word,
                deleteWord = { word ->
                    viewModel.deleteWord(word)
                },
                navigateToUpdateWordScreen = navigateToUpdateWordScreen
            )

            AddWordAlertDialog(

                openDialog = viewModel.openDialog,
                closeDialog = { viewModel.closeDialog() },
                addWord = { word -> viewModel.addWord(word) },
                LocalContext.current

            )


        },

        floatingActionButton = {

            AddWordFloatingActionButton(openDialog = { viewModel.openDialog() },TEXT_ADD_ACTION_BUTTON)
        }


    )


}