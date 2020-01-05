package com.tenxgames.surway.modules.categorysurveys.data

import androidx.lifecycle.LiveData
import com.tenxgames.surway.api.RestApi
import com.tenxgames.surway.modules.surveysmain.data.model.SurveyEntity

class CategorySurveysRepository(private val api: RestApi) {

    suspend fun loadSurveysByCategory(categoryId: Long): LiveData<List<SurveyEntity>> {
        return api.loadSurveysByCategory(categoryId)
    }
}