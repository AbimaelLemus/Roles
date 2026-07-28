package com.example.roles.data.mapper

import com.example.roles.data.remote.RemoteRecordDto
import com.example.roles.domain.model.RegisterPerson


fun RemoteRecordDto.toDomain() =
    RegisterPerson(
        id = id,
        name = name,
        age = age,
        educationLevel = educationLevel
    )