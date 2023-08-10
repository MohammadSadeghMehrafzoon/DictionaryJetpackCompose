package ir.misterdeveloper.mydictionary.database.network

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.misterdeveloper.mydictionary.database.dao.WordDao
import ir.misterdeveloper.mydictionary.domain.model.Word


@Database(
    entities = [Word::class],
    version = 1,
    exportSchema = false
)
abstract class WordDb : RoomDatabase() {
    abstract val wordDao: WordDao
}