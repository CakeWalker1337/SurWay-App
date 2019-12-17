package com.tenxgames.surway.modules.surveys.ui.model

import com.tenxgames.surway.modules.surveys.data.model.SurveyEntity

data class Survey(
    val id: Int,
    val title: String,
    val description: String
)

fun SurveyEntity.toPresentation() =
    Survey(
        id = this.id,
        title = this.title,
        description = this.description
    )