package ir.misterdeveloper.mydictionary.database.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.IGNORE
import ir.misterdeveloper.mydictionary.core.Constants.Companion.WORD_TABLE
import ir.misterdeveloper.mydictionary.domain.model.Word
import ir.misterdeveloper.mydictionary.domain.repository.Words
import kotlinx.coroutines.flow.Flow


@Dao
interface WordDao {


    @Query("SELECT * FROM $WORD_TABLE ORDER BY id ASC")
    fun getWords(): Flow<Words>

    @Query("SELECT * FROM $WORD_TABLE WHERE id = :id")
    suspend fun getWord(id: Int): Word

    @Insert(onConflict = IGNORE)
    suspend fun addWord(word: Word)

    @Update
    suspend fun updateWord(word: Word)

    @Delete
    suspend fun deleteWord(word: Word)


}