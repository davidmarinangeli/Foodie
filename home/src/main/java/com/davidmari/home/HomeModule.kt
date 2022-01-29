package com.davidmari.home

import com.davidmari.home.ui.MainActivity
import org.koin.dsl.module

val homeModule = module {
    factory { MainActivity() }

}