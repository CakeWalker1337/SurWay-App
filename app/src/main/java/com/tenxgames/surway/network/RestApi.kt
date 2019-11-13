package com.tenxgames.surway.network

import androidx.lifecycle.LiveData
import com.tenxgames.surway.auth.data.UserEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {

    @GET
    fun loadUser(@Query("email") email: String): LiveData<UserEntity>

}