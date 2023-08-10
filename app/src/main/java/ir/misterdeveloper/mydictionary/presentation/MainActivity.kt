package ir.misterdeveloper.mydictionary.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.misterdeveloper.mydictionary.navigation.NavGraph
import ir.misterdeveloper.mydictionary.ui.theme.MyDictionaryTheme


@AndroidEntryPoint
@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            NavGraph(
                navHostController = rememberNavController()
            )


        }
    }
}