package com.davidmari.home.entities.imagesEntities

data class UnsplashResponse(
    val results: List<Result>,
    val total: Int,
    val total_pages: Int
)

data class Urls(
    val regular: String
)

data class Result(
    val id: String,
    val urls: Urls,
)