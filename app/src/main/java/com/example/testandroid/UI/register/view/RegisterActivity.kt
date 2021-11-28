package com.example.testandroid.UI.register.view

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.example.testandroid.R
import com.example.testandroid.UI.login.LoginActivity
import com.example.testandroid.UI.register.model.ResponseRegister
import com.example.testandroid.UI.register.presenter.RegisterPresenter
import com.example.testandroid.UI.register.presenter.RegisterView

class RegisterActivity : AppCompatActivity(), RegisterView {

    private var presenter: RegisterPresenter? = null

    private var btnSignUp: Button? = null
    private var etNama: EditText? = null
    private var etEmail: EditText? = null
    private var etPassword: EditText? = null
    private var etNoHp: EditText? = null
    private var etRePassword: EditText? = null
    private var progressBar: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        presenter = RegisterPresenter(this)

        progressBar = ProgressDialog(this)
        progressBar?.setMessage("Loading...")
        progressBar?.setProgressStyle(ProgressDialog.STYLE_SPINNER)

        btnSignUp = findViewById(R.id.btn_register)
        etNama = findViewById(R.id.ed_name)
        etEmail = findViewById(R.id.ed_email)
        etPassword = findViewById(R.id.ed_password)
        etNoHp = findViewById(R.id.ed_hp)
        etRePassword = findViewById(R.id.ed_repassword)


        btnSignUp?.setOnClickListener {
            showProgress()
            // ambil inputan user yg register
            val nama = etNama?.text.toString()
            val email = etEmail?.text.toString()
            val password = etPassword?.text.toString()
            val nohp = etNoHp?.text.toString()
            val passConf = etRePassword?.text.toString()
            presenter?.register(nama, nohp, email, password, passConf)
        }

    }

    override fun successRegister(response: ResponseRegister) {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    override fun errorRegister(msg: String) {
        showToast(msg)
    }

    override fun empty() {
        showToast("password tidak boleh kosong")
    }

    override fun noMatch() {
        showToast("password tidak cocok")
    }

    override fun showProgress() {
        progressBar?.show()
    }

    override fun hideProgress() {
        progressBar?.dismiss()
    }

    fun showToast (msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}