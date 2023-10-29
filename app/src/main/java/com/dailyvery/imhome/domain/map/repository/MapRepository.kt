package com.dailyvery.imhome.domain.map.repository

import com.dailyvery.imhome.domain.map.model.MapIntent
import kotlinx.coroutines.flow.Flow

interface MapRepository {
    val mapIntents: Flow<MapIntent>
    suspend fun sendMapIntent(mapIntent: MapIntent)
}