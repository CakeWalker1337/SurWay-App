package com.tenxgames.surway

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.tenxgames.surway.api.RestApi
import com.tenxgames.surway.base.ViewModelFactory
import com.tenxgames.surway.modules.auth.di.AuthModule
import com.tenxgames.surway.modules.surveys.data.SurveysRepository
import com.tenxgames.surway.modules.surveys.ui.mysurveys.AllSurveysViewModel
import com.tenxgames.surway.utils.bindViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.direct
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import retrofit2.Retrofit

class SurWayApp : Application(), KodeinAware {
    override val kodein: Kodein
        get() = Kodein {
            import(AuthModule().provide())
            bind<SurveysRepository>() with singleton { SurveysRepository(instance()) }
            bind<ViewModelProvider.Factory>() with singleton { ViewModelFactory(kodein.direct) }
            bindViewModel<AllSurveysViewModel>() with provider { AllSurveysViewModel(instance()) }
            bind<RestApi>() with singleton { Retrofit.Builder().baseUrl("https://rofl.com").build().create(RestApi::class.java) }
        }

    override fun onCreate() {
        super.onCreate()

    }

}