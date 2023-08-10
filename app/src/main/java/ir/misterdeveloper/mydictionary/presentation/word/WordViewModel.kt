package ir.misterdeveloper.mydictionary.presentation.word


import androidx.compose.runtime.getValue

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.setValue
import ir.misterdeveloper.mydictionary.core.Constants.Companion.EMPTY_STRING
import ir.misterdeveloper.mydictionary.domain.model.Word
import ir.misterdeveloper.mydictionary.domain.repository.WordRepository

import javax.inject.Inject

import kotlinx.coroutines.launch




@HiltViewModel
class WordViewModel @Inject constructor(
    private val repo: WordRepository
) : ViewModel() {

    var wordMutable  by  mutableStateOf(Word(0, EMPTY_STRING, EMPTY_STRING))
        private set

    var openDialog by mutableStateOf(false)


    val word = repo.getWordsFromRoom()

    fun getWord(id: Int) = viewModelScope.launch {
        wordMutable = repo.getWordFromRoom(id)
    }

    fun addWord(word: Word) = viewModelScope.launch {
        repo.addWordToRoom(word)
    }

    fun updateWord(word: Word) = viewModelScope.launch {
        repo.updateWordInRoom(word)
    }

    fun deleteWord(word: Word) = viewModelScope.launch {
        repo.deleteWordFromRoom(word)
    }

    fun updateTitle(title: String) {
        wordMutable = wordMutable.copy(
            title = title
        )
    }

    fun updateDescription(description: String) {
        wordMutable = wordMutable.copy(
            description = description
        )
    }

    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
    }
}