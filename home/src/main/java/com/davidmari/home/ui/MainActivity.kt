package com.davidmari.home.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.davidmari.home.entities.Recipe
import com.davidmari.home.uicomponents.RecipeListItem
import com.davidmari.resources.theme.FoodieTheme
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    val homeViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FoodieTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    Greeting(homeViewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(homeViewModel: HomeViewModel?) {

    val recipesList: List<Recipe> = homeViewModel?.recipesLD?.observeAsState()?.value ?: listOf()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column() {

            Text(text = "Recommended", style = MaterialTheme.typography.titleMedium)
            LazyRow {

                // Add a single item
                items(items = recipesList) { item ->
                    RecipeListItem(
                        title = item.title ?: "No Title",
                        ingredientsSize = item.extendedIngredients?.size ?: 0,
                        image = item.image,
                        readyIn = item.readyInMinutes ?: 0
                    )
                }
            }
            Text(text = "Top Categories", style = MaterialTheme.typography.titleMedium)
            LazyRow {

                // Add a single item
                items(items = recipesList) { item ->
                    RecipeListItem(
                        title = item.title ?: "No Title",
                        ingredientsSize = item.extendedIngredients?.size ?: 0,
                        image = item.image,
                        readyIn = item.readyInMinutes ?: 0
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FoodieTheme {
        Greeting(null)
    }
}