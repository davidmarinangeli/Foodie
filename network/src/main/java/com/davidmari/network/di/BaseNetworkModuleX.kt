package com.davidmari.network.di

import com.davidmari.network.NetworkResources.Companion.SPOONACULAR_BASE_URL
import com.davidmari.network.NetworkResources.Companion.UNSPLASH_BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val baseNetworkModule = module {

    factory<okhttp3.Interceptor> {
        HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).setLevel(
            HttpLoggingInterceptor.Level.BODY
        )
    }

    factory {
        OkHttpClient.Builder().addInterceptor(interceptor = get()).build()
    }

    factory<Moshi> {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    factory<Retrofit.Builder>(named("spoonacular")) {
        Retrofit.Builder()
            .baseUrl(SPOONACULAR_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .client(get())
    }

    factory<Retrofit.Builder>(named("unsplash")){
        Retrofit.Builder()
            .baseUrl(UNSPLASH_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .client(get())
    }
}