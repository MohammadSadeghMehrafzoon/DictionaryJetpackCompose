package ir.misterdeveloper.mydictionary.navigation

import ir.misterdeveloper.mydictionary.core.Constants.Companion.UPDATE_WORD_SCREEN
import ir.misterdeveloper.mydictionary.core.Constants.Companion.WORD_SCREEN


sealed class Screen(val route: String) {
    object WordScreen: Screen(WORD_SCREEN)
    object UpdateWordScreen: Screen(UPDATE_WORD_SCREEN)
}