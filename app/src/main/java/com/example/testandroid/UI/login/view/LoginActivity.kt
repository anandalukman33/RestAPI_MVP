package com.example.testandroid.UI.login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.testandroid.R
import com.example.testandroid.data.UserData

class LoginActivity : AppCompatActivity() {

    private var tvName: TextView? = null
    private var tvEmail: TextView? = null
    private var tvPassword: TextView? = null
    private var tvPhone: TextView? = null

    private var name: String? = null
    private var email: String? = null
    private var password: String? = null
    private var phone: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tvName = findViewById(R.id.tv_name)
        tvEmail = findViewById(R.id.tv_email)
        tvPassword = findViewById(R.id.tv_password)
        tvPhone = findViewById(R.id.tv_hp)

        name =  intent.getStringExtra(UserData.NAME)
        email = intent.getStringExtra(UserData.EMAIL)
        password = intent.getStringExtra(UserData.PASSWORD)
        phone = intent.getStringExtra(UserData.PHONE)

        tvName?.text = name
        tvEmail?.text = email
        tvPassword?.text = password
        tvPhone?.text = phone

    }
}