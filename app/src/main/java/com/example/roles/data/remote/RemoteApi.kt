package com.example.roles.data.remote

import retrofit2.http.GET

interface RemoteApi {
    @GET("persons")
    suspend fun getPersons(): List<RemoteRecordDto>

}