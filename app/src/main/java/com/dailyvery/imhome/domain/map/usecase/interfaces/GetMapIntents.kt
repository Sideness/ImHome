package com.dailyvery.imhome.domain.map.usecase.interfaces

import com.dailyvery.imhome.domain.map.model.MapIntent
import kotlinx.coroutines.flow.Flow

interface GetMapIntents {
    operator fun invoke(): Flow<MapIntent>
}