package ir.misterdeveloper.mydictionary.presentation.updateWord.components

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.misterdeveloper.mydictionary.core.Constants
import ir.misterdeveloper.mydictionary.domain.model.Word
import ir.misterdeveloper.mydictionary.presentation.word.WordViewModel
import ir.misterdeveloper.mydictionary.util.toast

import kotlinx.coroutines.job


@Composable
fun UpdateWordAlertDialog(
    word: Word,
    openDialog: Boolean,
    closeDialog: () -> Unit,
    context: Context,
    navigateBack: () -> Unit,
    viewModel: WordViewModel = hiltViewModel()
) {


    if (openDialog) {

        var title by remember { mutableStateOf(word.title) }
        var decription by remember { mutableStateOf(word.description) }

        val focusRequest = FocusRequester()

        AlertDialog(
            onDismissRequest = closeDialog,
            title = {
                Text(
                    text = Constants.ADD_WORD
                )
            },
            text = {
                Column(modifier = Modifier.padding(top = 8.dp)) {
                    OutlinedTextField(
                        value = title,
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Create,
                                contentDescription = ""
                            )
                        },
                        onValueChange = {
                            title = it

                        },
                        label = { Text(text = "Enter Your Note") },
                        modifier = Modifier.focusRequester(focusRequest)
                    )
                    LaunchedEffect(Unit) {
                        coroutineContext.job.invokeOnCompletion {
                            focusRequest.requestFocus()
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    OutlinedTextField(
                        value = decription,
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Create,
                                contentDescription = ""
                            )
                        },
                        onValueChange = { decription = it },
                        label = { Text(text = "Enter Your Description") },
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        if (title == "" || decription == "") {

                            context.toast(context)
                        } else {
                            closeDialog()

                            viewModel.updateTitle(title)
                            viewModel.updateDescription(decription)
                            viewModel.updateWord(viewModel.wordMutable)
                            navigateBack()
                        }
                    }
                ) {
                    Text(
                        text = Constants.UPDATE_BUTTON
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog,

                    ) {
                    Text(
                        text = Constants.DISMISS_BUTTON, color = Color.DarkGray
                    )
                }
            }
        )


    }


}