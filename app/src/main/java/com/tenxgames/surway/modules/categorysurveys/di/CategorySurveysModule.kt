package com.tenxgames.surway.modules.categorysurveys.di

import com.tenxgames.surway.di.KodeinProvider
import com.tenxgames.surway.modules.categorysurveys.data.CategorySurveysRepository
import com.tenxgames.surway.modules.categorysurveys.ui.CategorySurveysViewModel
import com.tenxgames.surway.utils.bindViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class CategorySurveysModule : KodeinProvider {
    override fun provide(): Kodein.Module {
        return categorySurveysModule
    }

    private val categorySurveysModule: Kodein.Module
        get() =
            Kodein.Module("categorySurveysModule") {
                bind<CategorySurveysRepository>() with singleton { CategorySurveysRepository(instance()) }
                bindViewModel<CategorySurveysViewModel>() with provider { CategorySurveysViewModel(instance()) }
            }
}
