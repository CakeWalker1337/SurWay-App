package com.tenxgames.surway.modules.surveys.ui.mysurveys.model

import android.view.View
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import com.tenxgames.surway.R
import com.tenxgames.surway.utils.declareColor
import kotlinx.android.synthetic.main.survey_item_view.view.*

class SurveyItem(val survey: Survey) : AbstractItem<SurveyItem.ViewHolder>() {

    override val layoutRes: Int = R.layout.survey_item_view
    override val type: Int = R.id.survey_item

    override fun getViewHolder(v: View): ViewHolder = ViewHolder(v)

    class ViewHolder(private val view: View) : FastAdapter.ViewHolder<SurveyItem>(view) {
        override fun bindView(item: SurveyItem, payloads: MutableList<Any>) {
            view.tvName.text = item.survey.title
            view.tvDescription.text = item.survey.description
            view.tvStatus.text = item.survey.status.toString()
            view.tvStatus.setTextColor(item.survey.status.declareColor())
            view.tvCreatedDate.text = item.survey.created
        }

        override fun unbindView(item: SurveyItem) {
            view.tvName.text = null
            view.tvDescription.text = null
            view.tvStatus.text = null
            view.tvStatus.setTextColor(null)
            view.tvCreatedDate.text = null
        }
    }
}