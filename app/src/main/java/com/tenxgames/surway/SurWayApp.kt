package com.tenxgames.surway

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.tenxgames.surway.auth.AuthViewModel
import com.tenxgames.surway.auth.data.AuthRepository
import com.tenxgames.surway.base.ViewModelFactory
import com.tenxgames.surway.utils.bindViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.direct
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class SurWayApp : Application(), KodeinAware {
    override val kodein: Kodein
        get() = Kodein {
            bind<AuthRepository>() with singleton { AuthRepository() }
            bind<ViewModelProvider.Factory>() with singleton { ViewModelFactory(kodein.direct) }
            bindViewModel<AuthViewModel>() with provider { AuthViewModel(instance()) }
        }

    override fun onCreate() {
        super.onCreate()

    }

}