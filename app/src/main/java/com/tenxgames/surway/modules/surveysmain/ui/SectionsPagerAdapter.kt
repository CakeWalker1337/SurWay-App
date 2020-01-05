package com.tenxgames.surway.modules.surveysmain.ui

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.tenxgames.surway.R
import com.tenxgames.surway.modules.surveysmain.ui.mysurveys.CategoriesFragment
import com.tenxgames.surway.modules.surveysmain.ui.mysurveys.MySurveysFragment

private val TAB_TITLES = arrayOf(
    R.string.tab_all_surveys_title,
    R.string.tab_my_surveys_title
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a MySurveysFragment (defined as a static inner class below).
        return when (position) {
            0 -> CategoriesFragment.newInstance(position)
            1 -> MySurveysFragment.newInstance(position)
            else -> CategoriesFragment.newInstance(position)
        }

    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 2
    }
}