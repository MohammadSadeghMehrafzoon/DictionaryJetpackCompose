package ir.misterdeveloper.mydictionary.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ir.misterdeveloper.mydictionary.core.Constants.Companion.WORD_ID
import ir.misterdeveloper.mydictionary.presentation.updateWord.UpdateWordScreen
import ir.misterdeveloper.mydictionary.presentation.word.WordScreen


@Composable
@ExperimentalMaterialApi
fun NavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.WordScreen.route
    ) {
        composable(
            route = Screen.WordScreen.route
        ) {
            WordScreen(
                navigateToUpdateWordScreen = { wordId ->
                    navHostController.navigate(
                        route = "${Screen.UpdateWordScreen.route}/${wordId}"
                    )
                }
            )
        }
        composable(
            route = "${Screen.UpdateWordScreen.route}/{$WORD_ID}",
            arguments = listOf(
                navArgument(WORD_ID) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val bookId = backStackEntry.arguments?.getInt(WORD_ID) ?: 0
            UpdateWordScreen(
                wordId = bookId,
                navigateBack = {
                    navHostController.popBackStack()
                }
            )
        }
    }


}