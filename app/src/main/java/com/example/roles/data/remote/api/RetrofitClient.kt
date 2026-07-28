package com.example.roles.data.remote.api

import com.example.roles.data.remote.AuthApi
import com.example.roles.data.remote.RemoteApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "http://10.0.2.2:3000/"

    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val authApi: AuthApi by lazy {
        retrofit.create(AuthApi::class.java)
    }

    val remoteApi: RemoteApi by lazy {
        retrofit.create(RemoteApi::class.java)
    }

}