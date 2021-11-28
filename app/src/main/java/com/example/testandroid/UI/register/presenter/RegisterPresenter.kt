package com.example.testandroid.UI.register.presenter

import com.example.testandroid.UI.register.model.ResponseRegister
import com.example.testandroid.network.ConfigNetwork
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter(val registerView: RegisterView) {

    fun register(nama: String, hp: String, email: String, password: String, passConf: String) {
        registerView.showProgress()

        if (nama.isNotEmpty() && hp.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {

            if (password != passConf) {
                registerView.noMatch()
                registerView.hideProgress()

            } else if (password.length < 7) {
                registerView.errorRegister("password kependekan euy, minimal 7 karakter, ntar dihack loh...")
                registerView.hideProgress()
            }
            else {
                ConfigNetwork.getNetwork().register(nama, hp, email, password)
                    .enqueue(object : Callback<ResponseRegister> {
                        override fun onResponse(call: Call<ResponseRegister>, response: Response<ResponseRegister>) {
                            registerView.hideProgress()
                            if (response.isSuccessful) {
                                val responseServer = response.body()
                                val message = response.body()?.message
                                val status = response.body()?.isSuccess
                                if (status ?: true) {
                                    registerView.successRegister(responseServer!!)
                                } else {
                                    registerView.errorRegister(message ?: "")
                                }

                            }
                        }

                        override fun onFailure(call: Call<ResponseRegister>, t: Throwable) {
                            registerView.hideProgress()
                            registerView.errorRegister(t.localizedMessage)
                        }
                    })
            }

        } else {
            registerView.hideProgress()
            registerView.empty()
        }
    }
}