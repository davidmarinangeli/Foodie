package com.davidmari.home.repository

import com.davidmari.home.network.RecipesApi
import org.koin.dsl.module
import retrofit2.Retrofit

val recipesRepositoryModule = module {

    single {
        RecipesRepository(get())
    }

    single<RecipesApi> {
        (get() as Retrofit.Builder).build()
            .create(RecipesApi::class.java)
    }
}