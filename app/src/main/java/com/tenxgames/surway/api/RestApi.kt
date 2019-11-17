package com.tenxgames.surway.api

import androidx.lifecycle.LiveData
import com.tenxgames.surway.modules.auth.data.model.UserEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {

    @GET
    fun loadUser(@Query("email") email: String): LiveData<UserEntity>

}