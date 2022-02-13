package com.davidmari.home.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.davidmari.home.entities.recipesEntities.RecipeModel
import com.davidmari.home.entities.recipesEntities.RecipeTypeModel
import com.davidmari.home.uicomponents.CategoryItem
import com.davidmari.home.uicomponents.RecipeListItem
import com.davidmari.resources.theme.FoodieTheme
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

    val recipesList: List<RecipeModel> = homeViewModel?.recipesLD?.observeAsState()?.value ?: listOf()
    val categoriesList: List<RecipeTypeModel> = homeViewModel?.categoriesTypesLD?.observeAsState()?.value ?: listOf()

    Box(
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {
            Text(text = "Top Categories", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(top = 24.dp, bottom = 8.dp, start = 16.dp))
            LazyRow(modifier = Modifier.padding(start= 8.dp)) {
                // Add a single item
                items(items = categoriesList) { item ->
                    CategoryItem(
                        categoryName = item.title,
                        emoji = item.emoji,
                        recipesCount = item.size,
                    )
                }
            }
            Text(text = "Recommended for you", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(top = 16.dp, bottom = 8.dp, start = 16.dp))
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