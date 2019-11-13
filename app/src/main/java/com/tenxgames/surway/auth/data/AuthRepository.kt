package com.tenxgames.surway.auth.data

import androidx.lifecycle.LiveData
import com.tenxgames.surway.network.RestApi

class AuthRepository(private val api: RestApi) {
    suspend fun loadUser(email: String): LiveData<UserEntity> {
        return api.loadUser(email)
    }
}