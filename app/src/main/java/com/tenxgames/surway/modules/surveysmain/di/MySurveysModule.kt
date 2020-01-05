package com.tenxgames.surway.modules.surveysmain.di

import com.tenxgames.surway.di.KodeinProvider
import com.tenxgames.surway.modules.surveysmain.ui.mysurveys.MySurveysViewModel
import com.tenxgames.surway.utils.bindViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

class MySurveysModule : KodeinProvider {
    override fun provide(): Kodein.Module {
        return mySurveysModule
    }

    private val mySurveysModule: Kodein.Module
        get() =
            Kodein.Module("mySurveysModule") {
                bindViewModel<MySurveysViewModel>() with provider { MySurveysViewModel(instance()) }
            }
}