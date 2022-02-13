package com.davidmari.home.network

import com.davidmari.home.entities.recipesEntities.RandomRecipesResponse
import com.davidmari.home.entities.recipesEntities.RecipeTypeResponse
import com.davidmari.network.NetworkResources.Companion.SPOONACULAR_API_KEY
import retrofit2.http.*

interface RecipesApi {

    @GET("/recipes/random")
    suspend fun getRandomRecipes(
        @Query("number") number: Int,
        @Query("apiKey") token: String = SPOONACULAR_API_KEY,
        @Header("Accept") value: String = "application/json"
    ): RandomRecipesResponse

    @GET("/recipes/complexSearch")
    suspend fun getRecipesForCategory(
        @Query("type") type: String,
        @Query("apiKey") token: String = SPOONACULAR_API_KEY,
        @Header("Accept") value: String = "application/json"
    ): RecipeTypeResponse
}