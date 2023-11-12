package com.dailyvery.imhome.core.di.module

import com.dailyvery.imhome.ui.home.HomeBottomSheetViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {

    viewModel { HomeBottomSheetViewModel(get()) }

}