package com.tenxgames.surway.modules.surveys.data.model

import com.tenxgames.surway.modules.surveys.ui.mysurveys.model.Survey
import org.joda.time.DateTime

data class SurveyEntity(
    val id: Int,
    val title: String,
    val status: Status,
    val description: String,
    val categories: List<SurveyCategoryEntity>,
    val created: DateTime
) {

    enum class Status {
        PENDING_REVIEW,
        ACTIVE,
        DENIED;

        fun toPresentation(): Survey.Status {
            return when (this) {
                PENDING_REVIEW -> Survey.Status.PENDING_REVIEW
                ACTIVE -> Survey.Status.ACTIVE
                DENIED -> Survey.Status.DENIED
            }
        }
    }


}