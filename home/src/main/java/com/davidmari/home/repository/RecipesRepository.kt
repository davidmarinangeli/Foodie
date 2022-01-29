package com.davidmari.home.repository

import com.davidmari.home.entities.Recipe
import com.davidmari.home.network.RecipesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecipesRepository(
    private val recipesApi: RecipesApi
) {

    /**
     * This method will retrieve the list of random recipes
     */
    suspend fun getRandomRecipes(number: Int = 1): List<Recipe> {

        return withContext(Dispatchers.IO) {
            return@withContext recipesApi.getRandomRecipes(number).recipes
        }
    }
}