package ir.misterdeveloper.mydictionary.presentation.word.components

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ir.misterdeveloper.mydictionary.core.Constants.Companion.ADD_BUTTON
import ir.misterdeveloper.mydictionary.core.Constants.Companion.ADD_WORD
import ir.misterdeveloper.mydictionary.core.Constants.Companion.DISMISS_BUTTON
import ir.misterdeveloper.mydictionary.core.Constants.Companion.EMPTY_STRING
import ir.misterdeveloper.mydictionary.domain.model.Word
import ir.misterdeveloper.mydictionary.util.toast


import kotlinx.coroutines.job

@Composable
fun AddWordAlertDialog(

    openDialog: Boolean,
    closeDialog: () -> Unit,
    addWord: (word: Word) -> Unit,
    context: Context

) {

    if (openDialog) {

        var title by remember { mutableStateOf(EMPTY_STRING) }
        var decription by remember { mutableStateOf(EMPTY_STRING) }

        val focusRequest = FocusRequester()

        AlertDialog(
            onDismissRequest = closeDialog,
            title = {
                Text(
                    text = ADD_WORD
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
                        onValueChange = { title = it },
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
                            val word = Word(0, title, decription)
                            addWord(word)
                        }
                    }
                ) {
                    Text(
                        text = ADD_BUTTON
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog,

                    ) {
                    Text(
                        text = DISMISS_BUTTON, color = Color.DarkGray
                    )
                }
            }
        )
    }


}





