package com.dailyvery.imhome.data.search.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.math.BigInteger

@Serializable
data class GeoLocationDto(

    @SerialName("category")
    val category: String,

    @SerialName("display_name")
    val name: String,

    @SerialName("place_id")
    val id: Int,

    @SerialName("importance")
    val importance: Float,

    @SerialName("lon")
    val longitude: Double,

    @SerialName("lat")
    val latitude: Double,

    @SerialName("address")
    val address: AddressDto,

    @SerialName("osm_id")
    val osmId: Long,

    @SerialName("osm_type")
    val osmType: String,

    @SerialName("licence")
    val licence: String,

    @SerialName("boundingbox")
    val boundingBox: List<Float>
)