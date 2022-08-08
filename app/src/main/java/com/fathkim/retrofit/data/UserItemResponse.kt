package com.fathkim.retrofit.data

import com.google.gson.annotations.SerializedName

data class UserResponse(

	@field:SerializedName("UserItemResponse")
	val userItemResponse: List<UserItemResponse?>? = null
)