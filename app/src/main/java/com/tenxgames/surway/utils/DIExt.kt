package com.tenxgames.surway.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import org.kodein.di.Kodein.Builder
import org.kodein.di.KodeinAware
import org.kodein.di.direct
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance

/**
 * The extention function for binding view model by Kodein (syntax sugar for view model binding)
 * @param overrides Whether this bind must, may or must not override an existing binding
 */
inline fun <reified T : ViewModel> Builder.bindViewModel(overrides: Boolean? = null): Builder.TypeBinder<T> {
    return bind<T>(T::class.java.simpleName, overrides)
}

inline fun <reified VM : ViewModel, T> T.activityViewModel(): Lazy<VM> where T : KodeinAware, T : FragmentActivity =
    lazy { ViewModelProviders.of(this, direct.instance()).get(VM::class.java) }


inline fun <reified VM : ViewModel, T> T.fragmentViewModel(): Lazy<VM> where T : KodeinAware, T : Fragment =
    lazy { ViewModelProviders.of(this, direct.instance()).get(VM::class.java) }
