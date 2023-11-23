package com.stupendil.cyclecareaplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide

class optionInActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option_in)

        val btnLogin: Button = findViewById(R.id.btnToLogin)
        btnLogin.setOnClickListener(this)
        val btnRegist: Button = findViewById(R.id.btnToRegist)
        btnRegist.setOnClickListener(this)

        showGIF()
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnToLogin ->{
                val intent = Intent(this@optionInActivity, HomeActivity::class.java)
                startActivity(intent)
            }
        }

        when(v.id){
            R.id.btnToRegist ->{
                val intent = Intent(this@optionInActivity, RegistActivity::class.java)
                startActivity(intent)
            }
        }

    }

    private fun showGIF() {
        val imageView:ImageView = findViewById(R.id.imageView2)
        Glide.with(this).load(R.drawable.option1).into(imageView)
    }


}