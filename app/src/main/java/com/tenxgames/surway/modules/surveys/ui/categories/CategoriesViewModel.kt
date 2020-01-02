package com.tenxgames.surway.modules.surveys.ui.mysurveys

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tenxgames.surway.modules.surveys.data.SurveysRepository
import com.tenxgames.surway.modules.surveys.ui.categories.model.SurveyCategory

class CategoriesViewModel(private val repository: SurveysRepository) : ViewModel() {

    fun getMySurveys(): LiveData<List<SurveyCategory>> {
        val data = MutableLiveData<List<SurveyCategory>>()
        data.value = listOf(
            SurveyCategory(1, "Медицина", "Ваше здоровье превыше всего!", "https://png.pngtree.com/svg/20161117/release_time_24x24__139621.png", 3.1, "3 d. ago"),
            SurveyCategory(2, "Психология", "Психотипы и архитипы", "https://png.pngtree.com/svg/20160712/prompt_information_24x_595481.png", 3.1, "3 d. ago"),
            SurveyCategory(
                3,
                "Экология",
                "Охрана окружающей среды",
                "https://icons-for-free.com/iconfiles/png/512/fast+hourglass+hurry+late+monitor+test+time+work+icon-1320195341216089777.png",
                3.1,
                "3 d. ago"
            )
        )
        return data
//        return runBlocking {
//            Transformations.map(repository.loadSurveys(1)) { list -> list.map { it.toPresentation() } }
//        }
    }
}