package com.davidmari.home.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.davidmari.home.entities.recipesEntities.RecipeModel
import com.davidmari.home.entities.recipesEntities.RecipeTypeModel
import com.davidmari.home.entities.recipesEntities.RecipeTypeModel.Companion.getStandardMealTypes
import com.davidmari.home.repository.RecipesRepository
import kotlinx.coroutines.*

class HomeViewModel(
    val recipesRepository: RecipesRepository
) : ViewModel(
) {
    private val coroutineScope = CoroutineScope(Job() + Dispatchers.Main)

    val recipesLD: MutableLiveData<List<RecipeModel>> = MutableLiveData()
    val categoriesTypesLD: MutableLiveData<List<RecipeTypeModel>> = MutableLiveData()

    init {
        getRandomRecipes()
        getMealTypesRecipes()
    }

    private fun getRandomRecipes() {

        coroutineScope.launch {
            val result = withContext(Dispatchers.IO) {
                try {
                    recipesRepository.getRandomRecipes(7)
                } catch (e: Exception) {
                    null
                }
            }

//            result?.forEach { recipe ->
//                val image = try {
//                    recipe.title?.let { recipesRepository.getImage(it) }
//                } catch (e: Exception) {
//                    null
//                }
//                recipe.image = image
//            }

            recipesLD.postValue(result)
        }
    }

    private fun getMealTypesRecipes() {
        coroutineScope.launch {

            val standardMealTypes = getStandardMealTypes()
            standardMealTypes.map { mealType ->
                val result = withContext(Dispatchers.IO) {
                    try {
                        recipesRepository.getRecipesForCategory(
                            mealType.spoonacularType ?: mealType.title
                        )
                    } catch (e: Exception) {
                        null
                    }
                }
                mealType.size = result?.number ?: 0
            }

            categoriesTypesLD.postValue(standardMealTypes)
        }
    }
}