package com.tenxgames.surway.modules.surveys.ui.mysurveys

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tenxgames.surway.modules.surveys.data.SurveysRepository
import com.tenxgames.surway.modules.surveys.ui.mysurveys.model.Survey

class AllSurveysViewModel(private val repository: SurveysRepository) : ViewModel() {

    fun getMySurveys(): LiveData<List<Survey>> {
        val data = MutableLiveData<List<Survey>>()
        data.value = listOf(
            Survey(1, "The first survey ever!", Survey.Status.ACTIVE, "This is the first survey you can see this, yeah!", "1 d. ago"),
            Survey(2, "The second survey ever!", Survey.Status.ACTIVE, "This is the second survey you can see this, yeah!", "2 d. ago"),
            Survey(3, "The third survey ever!", Survey.Status.ACTIVE, "This is the third survey you can see this, yeah!", "3 d. ago")
        )
        return data
//        return runBlocking {
//            Transformations.map(repository.loadSurveys(1)) { list -> list.map { it.toPresentation() } }
//        }
    }
}