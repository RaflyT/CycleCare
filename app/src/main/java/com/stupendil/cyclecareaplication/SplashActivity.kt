package com.stupendil.cyclecareaplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            moveTo()
        },3000L)
    }

    private fun moveTo(){
        Intent(this, optionInActivity::class.java).also {
            startActivity(it)
            finish()
        }
    }
}