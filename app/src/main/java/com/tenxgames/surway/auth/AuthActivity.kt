package com.tenxgames.surway.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.tenxgames.surway.R

class AuthActivity : AppCompatActivity() {

    private lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_auth)
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)

    }

}
