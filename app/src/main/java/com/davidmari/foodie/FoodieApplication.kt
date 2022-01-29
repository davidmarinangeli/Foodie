package com.davidmari.foodie

import android.app.Application
import com.davidmari.home.homeModule
import com.davidmari.home.repository.recipesRepositoryModule
import com.davidmari.network.di.baseNetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class FoodieApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@FoodieApplication)
            modules(
                baseNetworkModule, recipesRepositoryModule, viewModelModule, homeModule,
            )
        }
    }
}
