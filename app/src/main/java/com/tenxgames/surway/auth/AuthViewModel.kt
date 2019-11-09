package com.tenxgames.surway.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import com.tenxgames.surway.auth.data.AuthRepository

class AuthViewModel(private val repository: AuthRepository) : ViewModel() {

    fun loadUser() {
        Log.d("Test", "ViewModel")
        repository.loadUser()
    }
}