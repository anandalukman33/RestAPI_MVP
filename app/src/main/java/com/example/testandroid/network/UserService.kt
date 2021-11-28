package com.example.testandroid.network

import com.example.testandroid.UI.register.model.ResponseRegister
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserService {

    @FormUrlEncoded
    @POST("Register.php")

    fun register(
        @Field("nama") nama : String,
        @Field("nohp") noHp : String,
        @Field("email") email : String,
        @Field("password") password : String

    ): Call<ResponseRegister>
}