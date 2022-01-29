package com.davidmari.home.network

import com.davidmari.home.entities.Recipe
import com.davidmari.home.entities.Recipes
import com.davidmari.network.NetworkResources.Companion.API_KEY
import retrofit2.http.*

interface RecipesApi {

    @GET("/recipes/random")
    suspend fun getRandomRecipes(
        @Query("number") number: Int,
        @Query("apiKey") token: String = API_KEY,
        @Header("Accept") value: String = "application/json"
    ): Recipes
}