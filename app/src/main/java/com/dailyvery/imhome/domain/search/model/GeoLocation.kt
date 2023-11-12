package com.dailyvery.imhome.domain.search.model

import com.dailyvery.imhome.data.search.remote.AddressDto

data class GeoLocation(
    val category: String,
    val name: String,
    val id: Int,
    val importance: Float,
    val longitude: Double,
    val latitude: Double,
    val address: Address,
    val osmId: Long,
    val licence: String,
)
