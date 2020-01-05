package com.tenxgames.surway.modules.surveysmain.data.model

import org.joda.time.DateTime

data class SurveyCategoryEntity(
    val id: Long,
    val name: String,
    val description: String,
    val imageUrl: String,
    val trend: Double,
    val updated: DateTime
)