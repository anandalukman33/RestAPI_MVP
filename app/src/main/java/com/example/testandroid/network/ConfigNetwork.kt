package com.example.testandroid.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigNetwork {

    companion object {
        fun getNetwork(): UserService {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://10.10.10.53/mentoringkotlin/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(UserService::class.java)
            return service
        }
    }
}