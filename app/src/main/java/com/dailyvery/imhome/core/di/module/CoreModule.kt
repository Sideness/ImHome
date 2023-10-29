package com.dailyvery.imhome.core.di.module

import com.dailyvery.imhome.ui.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val coreModule = module {
    viewModel { MainActivityViewModel(get()) }
}