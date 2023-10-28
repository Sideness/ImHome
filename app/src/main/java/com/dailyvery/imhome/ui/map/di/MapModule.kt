package com.dailyvery.imhome.ui.map.di

import com.dailyvery.imhome.ui.map.MapViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mapModule = module {
    viewModel { MapViewModel() }
}