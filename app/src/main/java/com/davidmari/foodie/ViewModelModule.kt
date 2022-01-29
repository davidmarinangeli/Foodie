package com.davidmari.foodie

import com.davidmari.home.ui.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        HomeViewModel(recipesRepository = get())
    }
}