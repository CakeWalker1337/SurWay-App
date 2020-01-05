package com.tenxgames.surway.modules.surveysmain.data

import androidx.lifecycle.LiveData
import com.tenxgames.surway.api.RestApi
import com.tenxgames.surway.modules.surveysmain.data.model.SurveyCategoryEntity
import com.tenxgames.surway.modules.surveysmain.data.model.SurveyEntity

class SurveysRepository(private val restApi: RestApi) {

    suspend fun loadSurveys(userId: Long): LiveData<List<SurveyEntity>> = restApi.loadSurveys(userId)


    suspend fun loadCategories(): LiveData<List<SurveyCategoryEntity>> = restApi.loadCategories()

}