package com.tenxgames.surway.modules.surveysmain

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mikepenz.materialdrawer.DrawerBuilder
import com.tenxgames.surway.R
import com.tenxgames.surway.modules.surveysmain.ui.SectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_surveys.*

class SurveysActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surveys)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        viewPager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(viewPager)
        tbSurveys.title = resources.getString(R.string.title_activity_surveys)
        DrawerBuilder().withActivity(this).withToolbar(tbSurveys).build()
    }
}