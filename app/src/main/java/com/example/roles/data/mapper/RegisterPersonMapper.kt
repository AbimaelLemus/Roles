package com.example.roles.data.mapper

import com.example.roles.data.local.entity.RegisterPersonEntity
import com.example.roles.domain.model.RegisterPerson

fun RegisterPerson.toEntity() =
    RegisterPersonEntity(
        id = id,
        name = name,
        age = age,
        educationLevel = educationLevel
    )

fun RegisterPersonEntity.toDomain() =
    RegisterPerson(
        id = id,
        name = name,
        age = age,
        educationLevel = educationLevel
    )