package com.giphyapp.core.contracts.mappers

interface BaseMapper<Target, Domain> {

    fun toDomain(model: Target): Domain
    fun toEntity(model: Domain): Target
}
