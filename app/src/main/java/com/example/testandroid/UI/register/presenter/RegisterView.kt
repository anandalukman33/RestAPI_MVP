package com.example.testandroid.UI.register.presenter

import com.example.testandroid.UI.register.model.ResponseRegister

interface RegisterView {

    fun successRegister(response: ResponseRegister)
    fun errorRegister(msg: String)
    fun empty()
    fun noMatch()
}