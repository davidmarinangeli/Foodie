package com.davidmari.home.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.davidmari.home.entities.recipesEntities.RecipeModel
import com.davidmari.home.entities.recipesEntities.RecipeTypeModel
import com.davidmari.home.uicomponents.CategoryItem
import com.davidmari.home.uicomponents.RecipeListItem
import com.davidmari.resources.R
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

    val recipesList: List<RecipeModel> =
        homeViewModel?.recipesLD?.observeAsState()?.value ?: listOf()
    val categoriesList: List<RecipeTypeModel> =
        homeViewModel?.categoriesTypesLD?.observeAsState()?.value ?: listOf()

    Box(
    ) {
        Image(
            painterResource(id = R.drawable.homescreen_background),
            null,
            Modifier
                .height(224.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillHeight,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Row() {
                Text(
                    text = "Hello, ",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(top = 54.dp, start = 16.dp),
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Text(
                    text = "Marco",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(top = 54.dp),
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
            Text(
                text = "pickup where you left",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 8.dp, start = 16.dp),
                color = MaterialTheme.colorScheme.onPrimary
            )
            Text(
                text = "Top Categories",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 62.dp, bottom = 8.dp, start = 16.dp),
                color = MaterialTheme.colorScheme.onSurface
            )
            LazyRow(modifier = Modifier.padding(start = 8.dp)) {
                // Add a single item
                items(items = categoriesList) { item ->
                    CategoryItem(
                        categoryName = item.title,
                        emoji = item.emoji,
                        recipesCount = item.size,
                    )
                }
            }
            Text(
                text = "Recommended for you",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp, start = 16.dp),
                color = MaterialTheme.colorScheme.onSurface
            )
            LazyRow {
                // Add a single item
                itemsIndexed(items = recipesList) { index, item ->
                    RecipeListItem(
                        title = item.title ?: "No Title",
                        ingredientsSize = item.extendedIngredients?.size ?: 0,
                        image = item.image,
                        readyIn = item.readyInMinutes ?: 0,
                        isPopular = item.cheap,
                        score = item.spoonacularScore,
                        itemIndex = index
                    )
                }
            }
        }
        FloatingActionButton(
            modifier = Modifier.align(Alignment.BottomEnd).padding(end = 16.dp, bottom = 24.dp),
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(12.dp),
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_baseline_add_24), "Add")
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