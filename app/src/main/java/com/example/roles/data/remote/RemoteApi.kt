package com.example.roles.data.remote

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RemoteApi {
    @GET("persons")
    suspend fun getPersons(): List<RemoteRecordDto>

    @POST("persons")
    suspend fun createPerson(
        @Body person: RemoteRecordDto
    ): RemoteRecordDto

}