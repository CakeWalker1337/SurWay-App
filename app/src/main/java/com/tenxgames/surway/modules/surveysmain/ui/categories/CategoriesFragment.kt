package com.tenxgames.surway.modules.surveysmain.ui.mysurveys

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.IAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.tenxgames.surway.R
import com.tenxgames.surway.base.BaseFragment
import com.tenxgames.surway.modules.categorysurveys.ui.CategorySurveysActivity
import com.tenxgames.surway.modules.surveysmain.ui.categories.model.SurveyCategory
import com.tenxgames.surway.modules.surveysmain.ui.categories.model.SurveyCategoryItem
import com.tenxgames.surway.utils.fragmentViewModel
import kotlinx.android.synthetic.main.fragment_all_surveys.view.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein


/**
 * A placeholder fragment containing a simple view.
 */
class CategoriesFragment : BaseFragment(), KodeinAware {

    override val kodein: Kodein by closestKodein()

    private val viewModel: CategoriesViewModel by fragmentViewModel()

    val itemAdapter = ItemAdapter<SurveyCategoryItem>()
    val adapter = FastAdapter.with(itemAdapter)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutRes(): Int = R.layout.fragment_all_surveys

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvSurveys = view.rvSurveys
        rvSurveys.adapter = adapter
        rvSurveys.layoutManager = LinearLayoutManager(context)
        rvSurveys.addItemDecoration(DividerItemDecoration(rvSurveys.context, DividerItemDecoration.VERTICAL))
        adapter.onClickListener = { itemView: View?, adapter: IAdapter<SurveyCategoryItem>, surveyItem: SurveyCategoryItem, i: Int ->
            val intent = Intent(context, CategorySurveysActivity::class.java)
            intent.putExtra(EXTRA_SURVEY_CATEGORY, surveyItem.surveyCategory)
            startActivity(intent)
            true
        }
        viewModel.getMySurveys().observe(this, Observer<List<SurveyCategory>> { list ->
            itemAdapter.add(list.map { SurveyCategoryItem(it) })
            adapter.notifyAdapterDataSetChanged()
        })
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): CategoriesFragment {
            return CategoriesFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}

const val EXTRA_SURVEY_CATEGORY = "EXTRA_SURVEY_CATEGORY"