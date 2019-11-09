package com.tenxgames.surway.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tenxgames.surway.auth.data.AuthRepository

class ViewModelFactory(private val repository: AuthRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AuthViewModel(repository) as T
    }
}