package com.example.testandroid.UI.splash

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.testandroid.MainActivity
import com.example.testandroid.R
import com.example.testandroid.UI.login.view.LoginActivity
import com.example.testandroid.helper.SessionManager
import java.util.*


class SplashScreenActivity : AppCompatActivity() {

    private var timer: Timer? = null
    private var progressBar: ProgressBar? = null
    private var i = 0
    var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val session = SessionManager(this)

        progressBar = findViewById(R.id.progressBar)
        progressBar?.progress = 0
        textView = findViewById(R.id.textView);
        textView?.text = ""


        val period: Long = 100
        timer = Timer()
        timer!!.schedule(object : TimerTask() {
            override fun run() {
                //this repeats every 100 ms
                if (i < 100) {
                    runOnUiThread { textView?.setText("$i%") }
                    progressBar?.setProgress(i)
                    i++
                } else {
                    //closing the timer
                    timer?.cancel()
                    if (session.login != false) {
                        val intent1 = Intent(this@SplashScreenActivity, MainActivity::class.java)
                        startActivity(intent1)
                        // close this activity
                        finish()
                    } else {
                        val intent2 = Intent(this@SplashScreenActivity, LoginActivity::class.java)
                        startActivity(intent2)
                        // close this activity
                        finish()
                    }
                }
            }
        }, 0, period)
    }
}