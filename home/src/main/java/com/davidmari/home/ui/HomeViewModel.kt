package com.davidmari.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.davidmari.home.entities.Recipe
import com.davidmari.home.repository.RecipesRepository
import kotlinx.coroutines.*

class HomeViewModel(
    val recipesRepository: RecipesRepository
) : ViewModel(
) {
    private val coroutineScope = CoroutineScope(Job() + Dispatchers.Main)

    val recipesLD: MutableLiveData<List<Recipe>> = MutableLiveData()

    init {
        getRandomRecipes()
    }

    private fun getRandomRecipes() {

        coroutineScope.launch {
            val result = withContext(Dispatchers.IO) {
                try {
                    recipesRepository.getRandomRecipes(2)
                } catch (e: Exception) {
                    null
                }
            }

            result?.forEach { recipe ->
                val image = try {
                    recipe.title?.let { recipesRepository.getImage(it) }
                } catch (e: Exception) {
                    null
                }
                recipe.image = image
            }

            recipesLD.postValue(result)
        }
    }
}