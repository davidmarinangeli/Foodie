package com.davidmari.home.entities.recipesEntities

data class RecipeTypeResponse(
    val number: Int,
    val offset: Int,
    val results: List<CategoryRecipe>,
    val totalResults: Int
)