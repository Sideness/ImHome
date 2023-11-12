package com.dailyvery.imhome.data.search.mapper

import com.dailyvery.imhome.data.search.remote.AddressDto
import com.dailyvery.imhome.data.search.remote.GeoLocationDto
import com.dailyvery.imhome.domain.search.model.Address
import com.dailyvery.imhome.domain.search.model.GeoLocation

fun GeoLocationDto.toGeoLocation() =
    GeoLocation(
        category = this.category,
        name = this.name,
        id = this.id,
        importance = this.importance,
        longitude = this.longitude,
        latitude = this.latitude,
        address = this.address.toAddress(),
        osmId = this.osmId,
        licence = this.licence,
    )

fun AddressDto.toAddress() =
    Address(
        city = this.city,
        number = this.number,
        road = this.road,
        suburb = this.suburb,
        state = this.state,
        postCode = this.postCode,
        country = this.country,
        countryCode = this.countryCode,
    )