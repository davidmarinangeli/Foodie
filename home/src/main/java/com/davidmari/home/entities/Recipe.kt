package com.davidmari.home.entities


data class Recipes(
    val recipes: List<Recipe>
)

data class Recipe(
    val aggregateLikes: Int?,
    val analyzedInstructions: List<Any>?,
    val cheap: Boolean?,
    val creditsText: String?,
    val cuisines: List<Any>?,
    val dairyFree: Boolean?,
    val dishTypes: List<String>?,
    val extendedIngredients: List<ExtendedIngredient>?,
    val gaps: String?,
    val glutenFree: Boolean?,
    val healthScore: Double?,
    val id: Int?,
    val image: String?,
    val imageType: String?,
    val instructions: String?,
    val ketogenic: Boolean?,
    val license: String?,
    val lowFodmap: Boolean?,
    val pricePerServing: Double?,
    val readyInMinutes: Int?,
    val servings: Int?,
    val sourceName: String?,
    val sourceUrl: String?,
    val spoonacularScore: Double?,
    val spoonacularSourceUrl: String?,
    val summary: String?,
    val sustainable: Boolean?,
    val title: String?,
    val vegan: Boolean?,
    val vegetarian: Boolean?,
    val veryHealthy: Boolean?,
    val veryPopular: Boolean?,
    val weightWatcherSmartPoints: Int?,
    val whole30: Boolean?,
    val winePairing: WinePairing?
)