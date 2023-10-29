package com.dailyvery.imhome.domain.map.usecase

import com.dailyvery.imhome.domain.map.model.MapIntent
import com.dailyvery.imhome.domain.map.repository.MapRepository
import com.dailyvery.imhome.domain.map.usecase.interfaces.GetMapIntents
import kotlinx.coroutines.flow.Flow

class GetMapIntentsImpl(
    private val mapRepository: MapRepository
): GetMapIntents {

    override fun invoke(): Flow<MapIntent> {
        return mapRepository.mapIntents
    }

}