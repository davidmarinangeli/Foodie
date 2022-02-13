package com.davidmari.home.entities.recipesEntities

data class RecipeTypeModel(
    val title: String,
    val emoji: String,
    var size: Int,
    val spoonacularType: String? = null
) {

    companion object {
        fun getStandardMealTypes(): List<RecipeTypeModel> {
            return listOf(
                RecipeTypeModel("Dessert", "\uD83E\uDDC1", 0),
                RecipeTypeModel("Main Course", "\uD83C\uDF56", 0),
                RecipeTypeModel("Appetizer", "\uD83E\uDD6A", 0),
                RecipeTypeModel("Snack", "\uD83C\uDF5F", 0),
                RecipeTypeModel("Beverage", "\uD83C\uDF79", 0),
                RecipeTypeModel("Sides", "\uD83E\uDD57", 0, "side dish")
            )
        }
    }
}