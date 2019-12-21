package com.tenxgames.surway.modules.auth.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.tenxgames.surway.modules.auth.data.AuthRepository
import com.tenxgames.surway.modules.auth.ui.model.User
import com.tenxgames.surway.modules.auth.ui.model.toPresentation
import kotlinx.coroutines.runBlocking

class AuthViewModel(private val repository: AuthRepository) : ViewModel() {

    fun test() {
        Log.d("AuthViewModel", "Test ViewModel")
        repository.test()
    }

    fun loadUser(email: String): LiveData<User> {
        return runBlocking {
            Log.d("Test", "ViewModel")
            Transformations.map(repository.loadUser(email)) { it.toPresentation() }
        }
    }
}