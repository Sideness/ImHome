package com.dailyvery.imhome.data.search.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddressDto(
    @SerialName("city")
    val city: String? = null,

    @SerialName("house_number")
    val number: String? = null,

    @SerialName("road")
    val road: String? = null,

    @SerialName("suburb")
    val suburb: String? = null,

    @SerialName("state")
    val state: String? = null,

    @SerialName("postcode")
    val postCode: String? = null,

    @SerialName("country")
    val country: String? = null,

    @SerialName("country_code")
    val countryCode: String? = null,
)
