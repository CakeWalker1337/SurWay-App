package com.tenxgames.surway.modules.categorysurveys.ui

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.IAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.tenxgames.surway.R
import com.tenxgames.surway.modules.surveysmain.ui.categories.model.SurveyCategory
import com.tenxgames.surway.modules.surveysmain.ui.mysurveys.EXTRA_SURVEY_CATEGORY
import com.tenxgames.surway.modules.surveysmain.ui.mysurveys.model.SurveyItem
import com.tenxgames.surway.utils.activityViewModel
import kotlinx.android.synthetic.main.activity_category_surveys.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein


class CategorySurveysActivity : AppCompatActivity(), KodeinAware {

    override val kodein: Kodein by closestKodein()

    private val viewModel: CategorySurveysViewModel by activityViewModel()
    private var category: SurveyCategory? = null

    val itemAdapter = ItemAdapter<SurveyItem>()
    val adapter = FastAdapter.with(itemAdapter)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_surveys)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        rvCategorySurveys.adapter = adapter
        rvCategorySurveys.layoutManager = LinearLayoutManager(this)
        rvCategorySurveys.addItemDecoration(DividerItemDecoration(rvCategorySurveys.context, DividerItemDecoration.VERTICAL))
        adapter.onClickListener = { view1: View?, iAdapter: IAdapter<SurveyItem>, surveyItem: SurveyItem, i: Int ->
            true
        }
        category = intent.getParcelableExtra(EXTRA_SURVEY_CATEGORY)
        category?.let {
            supportActionBar?.title = it.name
            viewModel.loadSurveysByCategoty(it.id).observe(this, Observer { list ->
                itemAdapter.clear()
                itemAdapter.add(list.map { survey -> SurveyItem(survey) })
                adapter.notifyAdapterDataSetChanged()
            })
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}