package com.dailyvery.imhome.domain.map.model

sealed class MapIntent {
    object Idle: MapIntent()
    object CenterOnUser: MapIntent()
}
