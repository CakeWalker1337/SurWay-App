package com.tenxgames.surway.modules.surveys.ui.mysurveys

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
import com.tenxgames.surway.modules.surveys.ui.mysurveys.model.Survey
import com.tenxgames.surway.modules.surveys.ui.mysurveys.model.SurveyItem
import com.tenxgames.surway.utils.fragmentViewModel
import kotlinx.android.synthetic.main.fragment_my_surveys.view.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein


/**
 * A placeholder fragment containing a simple view.
 */
class MySurveysFragment : BaseFragment(), KodeinAware {

    override val kodein: Kodein by closestKodein()

    private val mViewModel: MySurveysViewModel by fragmentViewModel()

    val itemAdapter = ItemAdapter<SurveyItem>()
    val adapter = FastAdapter.with(itemAdapter)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutRes(): Int = R.layout.fragment_my_surveys

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvSurveys = view.rvMySurveys
        rvSurveys.adapter = adapter
        rvSurveys.layoutManager = LinearLayoutManager(context)
        rvSurveys.addItemDecoration(DividerItemDecoration(rvSurveys.context, DividerItemDecoration.VERTICAL))
        adapter.onClickListener = { view1: View?, iAdapter: IAdapter<SurveyItem>, surveyItem: SurveyItem, i: Int ->
            true
        }
        mViewModel.getMySurveys().observe(this, Observer<List<Survey>> { list ->
            itemAdapter.add(list.map { SurveyItem(it) })
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
        fun newInstance(sectionNumber: Int): MySurveysFragment {
            return MySurveysFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}