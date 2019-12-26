package com.tenxgames.surway.modules.surveys.ui.allsurveys.model

import com.tenxgames.surway.modules.surveys.data.model.SurveyCategoryEntity
import com.tenxgames.surway.utils.toCreatedDateString

data class SurveyCategory(
    val id: Long,
    val name: String,
    val description: String,
    val imageUrl: String,
    val trend: Double,
    val updated: String
)

fun SurveyCategoryEntity.toPresentation() =
    SurveyCategory(
        id = this.id,
        name = this.name,
        description = this.description,
        imageUrl = this.imageUrl,
        trend = this.trend,
        updated = this.updated.toCreatedDateString()
    )