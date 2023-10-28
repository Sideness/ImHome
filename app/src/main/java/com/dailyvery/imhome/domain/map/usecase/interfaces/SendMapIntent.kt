package com.dailyvery.imhome.domain.map.usecase.interfaces

import com.dailyvery.imhome.domain.map.model.MapIntent

interface SendMapIntent {
    suspend operator fun invoke(mapIntent: MapIntent)
}