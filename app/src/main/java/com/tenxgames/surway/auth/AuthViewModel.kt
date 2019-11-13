package com.tenxgames.surway.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.tenxgames.surway.auth.data.AuthRepository
import kotlinx.coroutines.runBlocking

class AuthViewModel(private val repository: AuthRepository) : ViewModel() {

    fun loadUser(email: String): LiveData<User> {
        return runBlocking {
            Log.d("Test", "ViewModel")
            Transformations.map(repository.loadUser(email)) { it.toPresentation() }
        }
    }
}