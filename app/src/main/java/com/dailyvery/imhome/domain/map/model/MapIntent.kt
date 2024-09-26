package com.dailyvery.imhome.domain.map.model

sealed class MapIntent {
    object CenterOnUser: MapIntent()
}
