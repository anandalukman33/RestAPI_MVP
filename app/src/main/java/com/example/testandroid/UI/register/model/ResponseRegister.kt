package com.example.testandroid.UI.register.model

import com.google.gson.annotations.SerializedName

data class ResponseRegister(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("isSuccess")	
	val isSuccess: Boolean? = null
)
