package ir.misterdeveloper.mydictionary.database.repository

import ir.misterdeveloper.mydictionary.database.dao.WordDao
import ir.misterdeveloper.mydictionary.domain.model.Word
import ir.misterdeveloper.mydictionary.domain.repository.WordRepository


class WordRepositoryImpl(
    private val wordDao: WordDao
): WordRepository {



    override fun getWordsFromRoom() = wordDao.getWords()

    override suspend fun getWordFromRoom(id: Int) = wordDao.getWord(id)

    override suspend fun addWordToRoom(word: Word) = wordDao.addWord(word)

    override suspend fun updateWordInRoom(word: Word) = wordDao.updateWord(word)

    override suspend fun deleteWordFromRoom(word: Word) = wordDao.deleteWord(word)
}