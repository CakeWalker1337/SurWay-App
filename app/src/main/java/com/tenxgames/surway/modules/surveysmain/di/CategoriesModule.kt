package com.tenxgames.surway.modules.surveysmain.di

import com.tenxgames.surway.di.KodeinProvider
import com.tenxgames.surway.modules.surveysmain.ui.mysurveys.CategoriesViewModel
import com.tenxgames.surway.utils.bindViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

class CategoriesModule : KodeinProvider {
    override fun provide(): Kodein.Module {
        return categoriesModule
    }

    private val categoriesModule: Kodein.Module
        get() =
            Kodein.Module("categoriesModule") {
                bindViewModel<CategoriesViewModel>() with provider { CategoriesViewModel(instance()) }
            }
}