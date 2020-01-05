package com.tenxgames.surway.utils

import android.graphics.Color
import com.tenxgames.surway.modules.surveysmain.ui.mysurveys.model.Survey

fun Survey.Status.declareColor(): Int {
    return when (this) {
        Survey.Status.PENDING_REVIEW -> Color.rgb(255, 215, 100) // light orange
        Survey.Status.ACTIVE -> Color.rgb(144, 238, 144) // light green
        Survey.Status.DENIED -> Color.rgb(255, 100, 97) // light red
    }
}