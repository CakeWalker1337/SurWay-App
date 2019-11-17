package com.tenxgames.surway.modules.auth.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.tenxgames.surway.api.RestApi
import com.tenxgames.surway.modules.auth.data.model.UserEntity

class AuthRepository(private val api: RestApi) {
    suspend fun loadUser(email: String): LiveData<UserEntity> {
        return api.loadUser(email)
    }

    fun test() {
        Log.d("AuthRepository", "Test Repository!")
    }

}