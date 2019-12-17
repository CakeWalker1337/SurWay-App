package com.tenxgames.surway.modules.surveys.ui.mysurveys

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.tenxgames.surway.modules.surveys.data.SurveysRepository
import com.tenxgames.surway.modules.surveys.ui.model.Survey
import com.tenxgames.surway.modules.surveys.ui.model.toPresentation
import kotlinx.coroutines.runBlocking

class MySurveysViewModel(private val repository: SurveysRepository) : ViewModel() {

    private val _index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(_index) {
        "Hello world from section: $it"
    }

    fun getAllSurveys(): LiveData<Survey> {
        return runBlocking {
            Transformations.map(repository.loadSurveys()) { it.toPresentation() }
        }
    }
}