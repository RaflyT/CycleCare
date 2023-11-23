package com.stupendil.cyclecareaplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.stupendil.cyclecareaplication.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity(), View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener {

    private lateinit var mBinding:ActivityLoginBinding
    private lateinit var etNicknameEdt: EditText
    private lateinit var etPasswordEdt: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding =ActivityLoginBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)
        mBinding.passW.onFocusChangeListener= this

        etNicknameEdt = findViewById(R.id.nickname)
        etPasswordEdt = findViewById(R.id.passW)

        val bundle =intent.extras
        if (bundle != null){
            etNicknameEdt.setText(bundle.getString("nickname"))
            etPasswordEdt.setText(bundle.getString("password"))
        }

        val loginBtn: Button = findViewById(R.id.btnLogin)
        loginBtn.setOnClickListener(this)


        showGIF()
    }

    private fun showGIF() {
        val imageView: ImageView = findViewById(R.id.imageView4)
        Glide.with(this).load(R.drawable.loginpict).into(imageView)
    }

    private fun validateFullName(): Boolean {
        var errorMessage: String? = null
        val value: String = mBinding.nickname.text.toString()
        if (value.isEmpty()){
            errorMessage = "Invalid Username"
        }

        return errorMessage == null
    }

    private fun validatePassword(): Boolean {
        var errorMessage: String? = null
        val value: String = mBinding.passW.text.toString()
        if (value.isEmpty()) {
            errorMessage = "Invalid password"

        } else if (value.length < 8) {
            errorMessage = "Password must be 6 characters long"
        } else if (!value.matches(".*[A-Z].*".toRegex())) {
            errorMessage = "Must contain 1 upper-case character"
        } else if (!value.matches(".*[a-z].*".toRegex())) {
            errorMessage = "Must contain 1 lower-case character"
        } else if (!value.matches(".*[0123456789].*".toRegex())) {
            errorMessage = "Must contain 1 number character (0123456789)"
        }

        return errorMessage == null
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btnLogin -> {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivities(arrayOf(intent))
            }
        }
    }

    override fun onFocusChange(v: View?, hasFocus: Boolean) {
//        if (v != null){
//            when(v.id) {
//                R.id.nickname -> {
//                    if (hasFocus) {
//                        if (mBinding.etNickname.isErrorEnabled) {
//                            mBinding.etNickname.isErrorEnabled = false
//                        }
//                    } else {
//                        validateFullName()
//                    }
//                }
//                R.id.passW -> {
//                    if (hasFocus){
//                        if (mBinding.etPassword.isErrorEnabled){
//                            mBinding.etPassword.isErrorEnabled = false
//                        }
//                    }else {
//                        validatePassword()
//                    }
//                }
//            }
//        }
    }

    override fun onKey(v: View?, keyCode: Int, keyEvent: KeyEvent?): Boolean {
        return false
    }
}