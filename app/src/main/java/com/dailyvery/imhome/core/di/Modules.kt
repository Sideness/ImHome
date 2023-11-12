package com.dailyvery.imhome.core.di

import com.dailyvery.imhome.core.di.module.coreModule
import com.dailyvery.imhome.core.di.module.homeModule
import com.dailyvery.imhome.core.di.module.mapModule
import com.dailyvery.imhome.core.di.module.searchModule

val modules = listOf(
    coreModule,
    mapModule,
    homeModule,
    searchModule,
)