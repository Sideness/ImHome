package com.dailyvery.imhome.data.map.repository

import com.dailyvery.imhome.domain.map.model.MapIntent
import com.dailyvery.imhome.domain.map.repository.MapRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class MapRepositoryImpl: MapRepository {

    private val _mapIntents = MutableStateFlow<MapIntent>(MapIntent.Idle)
    override val mapIntents: Flow<MapIntent> = _mapIntents

    override suspend fun sendMapIntent(mapIntent: MapIntent) {
        _mapIntents.emit(mapIntent)
    }

}