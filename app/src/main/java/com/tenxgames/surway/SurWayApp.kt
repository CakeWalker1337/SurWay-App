package com.tenxgames.surway

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.tenxgames.surway.api.RestApi
import com.tenxgames.surway.base.ViewModelFactory
import com.tenxgames.surway.modules.auth.di.AuthModule
import com.tenxgames.surway.modules.categorysurveys.di.CategorySurveysModule
import com.tenxgames.surway.modules.surveysmain.di.SurveysMainModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.direct
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton
import retrofit2.Retrofit

class SurWayApp : Application(), KodeinAware {
    override val kodein: Kodein
        get() = Kodein {
            bind<ViewModelProvider.Factory>() with singleton { ViewModelFactory(kodein.direct) }
            import(AuthModule().provide())
            import(SurveysMainModule().provide())
            import(CategorySurveysModule().provide())
            bind<RestApi>() with singleton { Retrofit.Builder().baseUrl("https://rofl.com").build().create(RestApi::class.java) }
        }

    override fun onCreate() {
        super.onCreate()

    }

}