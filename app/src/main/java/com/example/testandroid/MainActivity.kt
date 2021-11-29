package com.example.testandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.testandroid.UI.login.view.LoginActivity
import com.example.testandroid.helper.SessionManager

class MainActivity : AppCompatActivity() {

    private var tvName: TextView? = null
    private var tvEmail: TextView? = null
    private var btnLogout: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvName = findViewById(R.id.tv_name)
        tvEmail = findViewById(R.id.tv_email)
        btnLogout = findViewById(R.id.btn_logout)

        val session = SessionManager(this)

        tvName?.text = session.nama
        tvEmail?.text = session.email

        btnLogout?.setOnClickListener {
            session.logOut()
            val intent = Intent(this, LoginActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK) // supaya saat onBackClick tidak kembali lagi ke mainActivity
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }

    }
}