package com.dailyvery.imhome.domain.search.model

import kotlinx.serialization.SerialName

data class Address(
    val city: String?,
    val number: String?,
    val road: String?,
    val suburb: String?,
    val state: String?,
    val postCode: String?,
    val country: String?,
    val countryCode: String?,
)