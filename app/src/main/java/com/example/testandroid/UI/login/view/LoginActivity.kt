package com.example.testandroid.UI.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.testandroid.MainActivity
import com.example.testandroid.R
import com.example.testandroid.UI.login.model.DataItem
import com.example.testandroid.UI.login.presenter.LoginPresenter
import com.example.testandroid.UI.login.presenter.LoginView
import com.example.testandroid.UI.register.view.RegisterActivity
import com.example.testandroid.data.UserData
import com.example.testandroid.helper.SessionManager

class LoginActivity : AppCompatActivity(), LoginView {

    private var edEmail: EditText? = null
    private var edPassword: EditText? = null

    private var btnLogin: Button? = null
    private var linkRegister: TextView? = null

    /*
    ** Percobaan intent data
     */
//    private var name: String? = null
//    private var email: String? = null
//    private var password: String? = null
//    private var phone: String? = null

    private var loginPresenter: LoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edEmail = findViewById(R.id.ed_email_login)
        edPassword = findViewById(R.id.ed_password_login)

        btnLogin = findViewById(R.id.btn_login)
        linkRegister = findViewById(R.id.register_click)

        // onClick Link Register
        linkRegister?.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        // btn onClick Login
        btnLogin?.setOnClickListener {
            val email = edEmail?.text.toString()
            val password = edPassword?.text.toString()
            loginPresenter?.login(email, password)
        }

        /*
        ** Percobaan intent data
         */
//        name =  intent.getStringExtra(UserData.NAME)
//        email = intent.getStringExtra(UserData.EMAIL)
//        password = intent.getStringExtra(UserData.PASSWORD)
//        phone = intent.getStringExtra(UserData.PHONE)


        loginPresenter = LoginPresenter(this)

    }

    override fun loginSuccess(msg: String, user: List<DataItem?>) {
        val session = SessionManager(this)
        session.email = user[0]?.userEmail
        session.nama = user[0]?.userNama
        session.hp = user[0]?.userHp

        session.login = true

        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun errorLogin(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}