package ir.misterdeveloper.mydictionary.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.misterdeveloper.mydictionary.core.Constants.Companion.WORD_TABLE
import ir.misterdeveloper.mydictionary.database.dao.WordDao
import ir.misterdeveloper.mydictionary.database.network.WordDb
import ir.misterdeveloper.mydictionary.database.repository.WordRepositoryImpl
import ir.misterdeveloper.mydictionary.domain.repository.WordRepository


@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    fun provideWordDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        WordDb::class.java,
        WORD_TABLE
    ).build()

    @Provides
    fun provideWordDao(
        wordDb: WordDb
    ) = wordDb.wordDao

    @Provides
    fun provideWordRepository(
        wordDao: WordDao
    ): WordRepository = WordRepositoryImpl(
        wordDao = wordDao
    )
}