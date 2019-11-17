package com.tenxgames.surway.modules.auth.di

import com.tenxgames.surway.di.KodeinProvider
import com.tenxgames.surway.modules.auth.data.AuthRepository
import com.tenxgames.surway.modules.auth.ui.AuthViewModel
import com.tenxgames.surway.utils.bindViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton


class AuthModule : KodeinProvider {
    override fun provide(): Kodein.Module {
        return authModule
    }

    private val authModule: Kodein.Module
        get() =
            Kodein.Module("authModule") {
                bind<AuthRepository>() with singleton { AuthRepository(instance()) }
                bindViewModel<AuthViewModel>() with provider { AuthViewModel(instance()) }
            }
}
