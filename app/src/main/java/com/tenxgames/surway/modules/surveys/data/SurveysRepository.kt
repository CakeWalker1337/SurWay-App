package com.tenxgames.surway.modules.surveys.data

import androidx.lifecycle.LiveData
import com.tenxgames.surway.api.RestApi
import com.tenxgames.surway.modules.surveys.data.model.SurveyEntity

class SurveysRepository(private val restApi: RestApi) {

    suspend fun loadSurveys(userId: Long): LiveData<List<SurveyEntity>> = restApi.loadSurveys(userId)

}