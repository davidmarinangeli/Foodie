package com.davidmari.home.network

import com.davidmari.home.entities.Recipes
import com.davidmari.home.entities.imagesEntities.UnsplashResponse
import com.davidmari.network.NetworkResources.Companion.UNSPLASH_API_KEY
import retrofit2.http.*

interface ImagesApi {

    @GET("/search/photos")
    suspend fun getImage(
        @Query("query") query: String,
        @Query("page") page: Int = 1,
        @Query("per_page") per_page: Int = 1,
        @Query("client_id") token: String = UNSPLASH_API_KEY,
        @Header("Accept") value: String = "application/json"
    ): UnsplashResponse
}