package com.davidmari.home.repository

import android.media.Image
import com.davidmari.home.network.ImagesApi
import com.davidmari.home.network.RecipesApi
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val recipesRepositoryModule = module {

    single {
        RecipesRepository(get(), get())
    }

    single<RecipesApi> {
        (get((named("spoonacular"))) as Retrofit.Builder).build()
            .create(RecipesApi::class.java)
    }

    single<ImagesApi> {
        (get((named("unsplash"))) as Retrofit.Builder).build()
            .create(ImagesApi::class.java)
    }
}