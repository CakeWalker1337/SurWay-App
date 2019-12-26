package com.tenxgames.surway.modules.surveys.ui.mysurveys.model

import com.tenxgames.surway.modules.surveys.data.model.SurveyEntity
import com.tenxgames.surway.modules.surveys.ui.allsurveys.model.SurveyCategory
import com.tenxgames.surway.modules.surveys.ui.allsurveys.model.toPresentation
import com.tenxgames.surway.utils.toCreatedDateString

data class Survey(
    val id: Int,
    val title: String,
    val status: Status,
    val description: String,
    val categories: List<SurveyCategory>,
    val created: String
) {
    enum class Status {
        PENDING_REVIEW,
        ACTIVE,
        DENIED;

        override fun toString(): String {
            return when (this) {
                PENDING_REVIEW -> "Ожидает ревью"
                ACTIVE -> "Активен"
                DENIED -> "Отклонён"
            }
        }
    }

}

fun SurveyEntity.toPresentation() =
    Survey(
        id = this.id,
        title = this.title,
        status = this.status.toPresentation(),
        description = this.description,
        categories = this.categories.map { it.toPresentation() },
        created = this.created.toCreatedDateString()
    )
