package com.example.testandroid.UI.login.presenter

import com.example.testandroid.UI.login.model.DataItem


interface LoginView {

    fun loginSuccess(msg: String, user: List<DataItem?>)
    fun errorLogin(msg: String)

}