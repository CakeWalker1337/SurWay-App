package com.tenxgames.surway.modules.surveys.ui.mysurveys

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tenxgames.surway.modules.surveys.data.SurveysRepository
import com.tenxgames.surway.modules.surveys.ui.categories.model.SurveyCategory
import com.tenxgames.surway.modules.surveys.ui.mysurveys.model.Survey

class MySurveysViewModel(private val repository: SurveysRepository) : ViewModel() {

    fun getMySurveys(): LiveData<List<Survey>> {
        val data = MutableLiveData<List<Survey>>()
        data.value = listOf(
            Survey(
                1, "The first survey ever!", Survey.Status.ACTIVE, "This is the first survey you can see this, yeah!", listOf(
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
                ), "1 d. ago"
            ),
            Survey(
                2, "The second survey ever!", Survey.Status.ACTIVE, "This is the second survey you can see this, yeah!", listOf(
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
                ), "2 d. ago"
            ),
            Survey(
                3, "The third survey ever!", Survey.Status.ACTIVE, "This is the third survey you can see this, yeah!", listOf(
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
                ), "3 d. ago"
            )
        )
        return data
//        return runBlocking {
//            Transformations.map(repository.loadSurveys(1)) { list -> list.map { it.toPresentation() } }
//        }
    }
}