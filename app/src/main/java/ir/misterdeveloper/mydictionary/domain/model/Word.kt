package ir.misterdeveloper.mydictionary.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.misterdeveloper.mydictionary.core.Constants.Companion.WORD_TABLE


@Entity(tableName = WORD_TABLE)
data class Word(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val description: String

)