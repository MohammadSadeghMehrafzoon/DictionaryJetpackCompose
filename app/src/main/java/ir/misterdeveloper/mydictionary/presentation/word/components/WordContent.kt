package ir.misterdeveloper.mydictionary.presentation.word.components


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ir.misterdeveloper.mydictionary.domain.model.Word
import ir.misterdeveloper.mydictionary.domain.repository.Words


@Composable
@ExperimentalMaterialApi
fun WordContent(
    padding: PaddingValues,
    words: Words,
    deleteWord: (word: Word) -> Unit,
    navigateToUpdateWordScreen: (wordId: Int) -> Unit
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)

    ) {
        items(
            items = words
        ) { word ->
            WordCard(
                word = word,
                deleteWord = {
                    deleteWord(word)
                },
                navigateToUpdateWordScreen = navigateToUpdateWordScreen
            )
        }
    }
}
