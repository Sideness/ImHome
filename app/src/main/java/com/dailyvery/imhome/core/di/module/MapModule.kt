package com.dailyvery.imhome.core.di.module

import com.dailyvery.imhome.data.map.repository.MapRepositoryImpl
import com.dailyvery.imhome.domain.map.repository.MapRepository
import com.dailyvery.imhome.domain.map.usecase.SendMapIntentImpl
import com.dailyvery.imhome.domain.map.usecase.interfaces.SendMapIntent
import com.dailyvery.imhome.ui.map.MapViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mapModule = module {
    viewModel { MapViewModel(get()) }

    single<MapRepository> { MapRepositoryImpl() }
    factory<SendMapIntent> { SendMapIntentImpl(get()) }
}