package ir.misterdeveloper.mydictionary.domain.repository

import ir.misterdeveloper.mydictionary.domain.model.Word
import kotlinx.coroutines.flow.Flow

typealias Words = List<Word>

interface WordRepository {


    fun getWordsFromRoom(): Flow<Words>

    suspend fun getWordFromRoom(id: Int): Word

    suspend fun addWordToRoom(word: Word)

    suspend fun updateWordInRoom(word: Word)

    suspend fun deleteWordFromRoom(word: Word)
}