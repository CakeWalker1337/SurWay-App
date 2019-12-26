package com.tenxgames.surway.api

import androidx.lifecycle.LiveData
import com.tenxgames.surway.modules.auth.data.model.UserEntity
import com.tenxgames.surway.modules.surveys.data.model.SurveyEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {

    @GET
    suspend fun loadUser(@Query("email") email: String): LiveData<UserEntity>

    @GET
    suspend fun loadSurveys(@Query("userId") userId: Long): LiveData<List<SurveyEntity>>


}