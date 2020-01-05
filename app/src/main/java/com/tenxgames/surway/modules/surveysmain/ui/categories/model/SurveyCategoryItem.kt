package com.tenxgames.surway.modules.surveysmain.ui.categories.model

import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.View
import com.bumptech.glide.Glide
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import com.tenxgames.surway.R
import com.tenxgames.surway.utils.toTrendString
import kotlinx.android.synthetic.main.survey_category_view.view.*
import kotlinx.android.synthetic.main.survey_item_view.view.*
import kotlinx.android.synthetic.main.survey_item_view.view.tvDescription
import kotlinx.android.synthetic.main.survey_item_view.view.tvName

class SurveyCategoryItem(val surveyCategory: SurveyCategory) : AbstractItem<SurveyCategoryItem.ViewHolder>() {

    override val layoutRes: Int = R.layout.survey_category_view
    override val type: Int = R.id.survey_item

    override fun getViewHolder(v: View): ViewHolder = ViewHolder(v)

    class ViewHolder(private val view: View) : FastAdapter.ViewHolder<SurveyCategoryItem>(view) {
        override fun bindView(item: SurveyCategoryItem, payloads: MutableList<Any>) {
            view.tvName.text = item.surveyCategory.name
            view.tvDescription.text = item.surveyCategory.description
            view.tvTrend.text = item.surveyCategory.trend.toTrendString()
            view.ivTrend.setImageDrawable(getTrendDrawable(item.surveyCategory.trend))
            view.tvUpdatedDate.text = item.surveyCategory.updated
            Glide.with(view)
                .load(Uri.parse(item.surveyCategory.imageUrl))
                .placeholder(view.context.getDrawable(R.drawable.ic_placeholder_category))
                .into(view.ivLogo)
        }

        override fun unbindView(item: SurveyCategoryItem) {
            view.tvName.text = null
            view.tvDescription.text = null
            view.tvStatus.text = null
            view.tvStatus.setTextColor(null)
            view.tvUpdatedDate.text = null
            view.ivLogo.setImageDrawable(null)
            view.ivTrend.setImageDrawable(null)
        }

        private fun getTrendDrawable(trend: Double): Drawable? =
            when {
                trend > 0.0 -> view.context.getDrawable(R.drawable.ic_trend_up_24dp)
                trend == 0.0 -> view.context.getDrawable(R.drawable.ic_trend_stable_24dp)
                trend < 0.0 -> view.context.getDrawable(R.drawable.ic_trend_down_24dp)
                else -> null
            }

    }


}