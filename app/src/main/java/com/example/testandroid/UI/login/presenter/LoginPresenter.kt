package com.example.testandroid.UI.login.presenter

import com.example.testandroid.UI.login.model.ResponseLogin
import com.example.testandroid.network.ConfigNetwork
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter (val login: LoginView) {
    fun login(email: String, password: String) {

        if (email.isNotEmpty() && password.isNotEmpty()) {

            ConfigNetwork.getNetwork().login(email, password)
                .enqueue(object : Callback<ResponseLogin> {
                    override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                        if (response.isSuccessful) {
                            val status = response.body()?.isSuccess
                            val message = response.body()?.message

                            if (status ?: true) {
                                login.loginSuccess(message!!, response.body()!!.data!!)
                            } else {
                                login.errorLogin(message ?: "")
                            }
                        }
                    }

                    override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                        login.errorLogin(t.localizedMessage)
                    }
                })
        } else {
            login.errorLogin("tidak boleh ada yang kosong")
        }
    }
}