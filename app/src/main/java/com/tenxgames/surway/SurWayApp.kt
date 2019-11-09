package com.tenxgames.surway

import android.app.Application
import com.tenxgames.surway.auth.AuthViewModel
import com.tenxgames.surway.auth.ViewModelFactory
import com.tenxgames.surway.auth.data.AuthRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class SurWayApp : Application() {

    override fun onCreate() {
        super.onCreate()
        val viewModelModule = Kodein {
            bind<AuthRepository>() with singleton { AuthRepository() }
            bind() from provider { ViewModelFactory(instance()) }
            bind() from provider { AuthViewModel(instance()) }
        }
    }

}