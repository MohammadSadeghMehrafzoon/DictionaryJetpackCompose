package ir.misterdeveloper.mydictionary.presentation.word.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.misterdeveloper.mydictionary.core.Constants
import ir.misterdeveloper.mydictionary.domain.model.Word
import ir.misterdeveloper.mydictionary.ui.theme.MyDictionaryTheme


@Composable
@ExperimentalMaterialApi
fun WordCard(
    word: Word,
    deleteWord: () -> Unit,
    navigateToUpdateWordScreen: (wordId: Int) -> Unit
) {

    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 4.dp)
            .requiredHeight(50.dp)
            .fillMaxWidth(),
        elevation = 20.dp,
        onClick = { navigateToUpdateWordScreen(word.id) }) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {


            TextTitle(
                wordTitle = word.title
            )


            DeleteIcon(
                deleteWord = deleteWord
            )

        }

    }


}

@ExperimentalMaterialApi
@Composable
fun TestUi() {

    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(start = 16.dp, end = 8.dp, top = 16.dp, bottom = 16.dp)
            .fillMaxWidth()
            .requiredHeight(50.dp),
        elevation = 20.dp,
        onClick = { }) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()

        ) {

            TextTitle(
                wordTitle = "I got it"
            )

            IconButton(
                onClick = { }
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = Constants.DELETE_WORD,
                )
            }
        }


    }

}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyDictionaryTheme {
        TestUi()
    }
}
