package ir.misterdeveloper.mydictionary.presentation.updateWord.components

import ir.misterdeveloper.mydictionary.ui.theme.MyDictionaryTheme


import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.misterdeveloper.mydictionary.core.Constants.Companion.TEXT_UPDATE_ACTION_BUTTON
import ir.misterdeveloper.mydictionary.domain.model.Word
import ir.misterdeveloper.mydictionary.presentation.word.WordViewModel
import ir.misterdeveloper.mydictionary.presentation.word.components.AddWordFloatingActionButton
import ir.misterdeveloper.mydictionary.presentation.word.components.TextTitle


@Composable
fun UpdateWordContent(

    paddingValues: PaddingValues,
    word: Word,
    navigateBack: () -> Unit,
    viewModel: WordViewModel = hiltViewModel()
) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween


    ) {


        Column() {

            TextTitleForUpdate(
                wordTitle = "Title:"
            )


            TextTitle(wordTitle = word.title)

            Spacer(modifier = Modifier.height(8.dp))

            TextTitleForUpdate(
                wordTitle = "Meaning:"
            )

            TextMeaning(meaning = word.description)

        }

        Scaffold(
            content = {

                UpdateWordAlertDialog(

                    word = word,
                    openDialog = viewModel.openDialog,
                    closeDialog = { viewModel.closeDialog() },
                    LocalContext.current,
                    navigateBack = navigateBack

                )

            },
            floatingActionButton = { AddWordFloatingActionButton(openDialog = { viewModel.openDialog() },TEXT_UPDATE_ACTION_BUTTON) })


    }


}

@ExperimentalMaterialApi
@Composable
fun TestUiUpdateWordContent() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween


    ) {


        Column() {

            TextTitleForUpdate(
                wordTitle = "Title:"
            )


            TextTitle(wordTitle = "I got it")

            Spacer(modifier = Modifier.height(8.dp))

            TextTitleForUpdate(
                wordTitle = "Meaning:"
            )

            TextMeaning(meaning = "فهیمدم")

        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, bottom = 30.dp),
        ) {

            Icon(imageVector = Icons.Default.Create, contentDescription = "")

        }


    }


}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun PreviewUpdateWordContent() {
    MyDictionaryTheme() {
        TestUiUpdateWordContent()
    }
}