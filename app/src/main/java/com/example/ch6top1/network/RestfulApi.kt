package com.example.ch6top1.network

import com.example.ch6top1.model.ResponseDataUserItem
import retrofit2.Call

import retrofit2.http.GET

interface RestfulApi {
    @GET("user")
    fun getAlluser(): Call<List<ResponseDataUserItem>>
}