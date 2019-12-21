package com.tenxgames.surway.modules.surveys.ui.model

import android.view.View
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import com.tenxgames.surway.R
import com.tenxgames.surway.modules.surveys.data.model.SurveyEntity

data class Survey(
    val id: Int,
    val title: String,
    val description: String
) : AbstractItem<Survey.ViewHolder>() {

    override val layoutRes: Int = R.layout.survey_item_view
    override val type: Int = R.id.survey_item

    override fun getViewHolder(v: View): ViewHolder = ViewHolder(v)

    class ViewHolder(view: View) : FastAdapter.ViewHolder<Survey>(view) {
        override fun bindView(item: Survey, payloads: MutableList<Any>) {
        }

        override fun unbindView(item: Survey) {
        }

    }


}



fun SurveyEntity.toPresentation() =
    Survey(
        id = this.id,
        title = this.title,
        description = this.description
    )
