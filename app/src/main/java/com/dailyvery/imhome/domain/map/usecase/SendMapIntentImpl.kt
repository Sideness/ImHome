package com.dailyvery.imhome.domain.map.usecase

import com.dailyvery.imhome.domain.map.model.MapIntent
import com.dailyvery.imhome.domain.map.repository.MapRepository
import com.dailyvery.imhome.domain.map.usecase.interfaces.SendMapIntent

class SendMapIntentImpl(
    private val mapRepository: MapRepository
): SendMapIntent {

    override suspend fun invoke(mapIntent: MapIntent) {
        mapRepository.sendMapIntent(mapIntent)
    }
}