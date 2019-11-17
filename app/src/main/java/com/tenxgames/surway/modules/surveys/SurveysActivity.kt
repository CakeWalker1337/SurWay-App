package com.tenxgames.surway.modules.surveys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tenxgames.surway.R
import com.tenxgames.surway.modules.surveys.ui.SectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_surveys.*

class SurveysActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surveys)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        viewPager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(viewPager)
    }
}