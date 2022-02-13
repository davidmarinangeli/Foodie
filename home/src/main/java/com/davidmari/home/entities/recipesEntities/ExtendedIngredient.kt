package com.davidmari.home.entities.recipesEntities

data class ExtendedIngredient(
    val aisle: String?,
    val amount: Double?,
    val consitency: String?,
    val id: Int?,
    val image: String?,
    val meta: List<String>?,
    val name: String?,
    val original: String?,
    val originalName: String?,
    val unit: String?
)