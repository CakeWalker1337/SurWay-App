package com.tenxgames.surway.modules.auth.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tenxgames.surway.R
import com.tenxgames.surway.modules.surveys.SurveysActivity
import com.tenxgames.surway.utils.activityViewModel
import kotlinx.android.synthetic.main.activity_auth.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein


class AuthActivity : AppCompatActivity(), KodeinAware {

    override val kodein: Kodein by closestKodein()

    private val viewModel: AuthViewModel by activityViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        btnLogin.setOnClickListener {
            viewModel.test()
            viewModel.loadUser("")

        }
    }

    fun openSurveysActivity() {
        startActivity(Intent(this, SurveysActivity::class.java))
    }

}
