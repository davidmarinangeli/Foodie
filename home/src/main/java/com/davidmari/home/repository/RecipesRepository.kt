package com.davidmari.home.repository

import com.davidmari.home.entities.recipesEntities.RecipeModel
import com.davidmari.home.entities.recipesEntities.RecipeTypeResponse
import com.davidmari.home.network.ImagesApi
import com.davidmari.home.network.RecipesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecipesRepository(
    private val recipesApi: RecipesApi,
    private val imagesApi: ImagesApi
) {

    /**
     * This method will retrieve the list of random recipes
     */
    suspend fun getRandomRecipes(number: Int = 1): List<RecipeModel> {

        return withContext(Dispatchers.IO) {

            return@withContext recipesApi.getRandomRecipes(number).recipes
        }
    }


    /**
     * This method will retrieve the list of recipes for a given category - FOR THE MOMENT we only need the number of them
     */
    suspend fun getRecipesForCategory(mealType: String): RecipeTypeResponse {

        return withContext(Dispatchers.IO) {
            return@withContext recipesApi.getRecipesForCategory(mealType)
        }
    }

    /**
     * This method will retrieve an image for the @param query
     */
    suspend fun getImage(query: String): String? {

        return withContext(Dispatchers.IO) {
            return@withContext imagesApi.getImage(query).results.firstOrNull()?.urls?.regular
        }
    }
}