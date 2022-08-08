package com.fathkim.retrofit.network

import com.fathkim.retrofit.data.UserItemResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    @GET("users")
    @Headers("Authorization: token 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")
    fun getLIstUser() : Call<ArrayList<UserItemResponse>>
}