package com.tenxgames.surway.modules.surveysmain.di

import com.tenxgames.surway.di.KodeinProvider
import com.tenxgames.surway.modules.surveysmain.data.SurveysRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class SurveysMainModule : KodeinProvider {
    override fun provide(): Kodein.Module {
        return surveysMainModule
    }

    private val surveysMainModule: Kodein.Module
        get() =
            Kodein.Module("surveysMainModule") {
                bind<SurveysRepository>() with singleton { SurveysRepository(instance()) }
                import(CategoriesModule().provide())
                import(MySurveysModule().provide())
            }
}