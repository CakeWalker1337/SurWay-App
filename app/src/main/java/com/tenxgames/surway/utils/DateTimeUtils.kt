package com.tenxgames.surway.utils

import org.joda.time.DateTime

const val MILLISECONDS_IN_MINUTE: Long = 1000 * 60
const val MILLISECONDS_IN_HOUR: Long = MILLISECONDS_IN_MINUTE * 60
const val MILLISECONDS_IN_DAY: Long = MILLISECONDS_IN_HOUR * 24
const val MILLISECONDS_IN_MONTH: Long = MILLISECONDS_IN_DAY * 30
const val MILLISECONDS_IN_YEAR: Long = MILLISECONDS_IN_MONTH * 12

fun DateTime.toCreatedDateString(): String {
    val currentDateTime = DateTime.now()
    if (currentDateTime.isBefore(this)) {
        return "error date"
    }
    val period = currentDateTime.minus(this.millis).millis

    return when {
        period < MILLISECONDS_IN_MINUTE -> "меньше минуты назад"
        period < MILLISECONDS_IN_HOUR -> "${period / MILLISECONDS_IN_MINUTE} мин. назад"
        period < MILLISECONDS_IN_DAY -> "${period / MILLISECONDS_IN_HOUR} ч. назад"
        period < MILLISECONDS_IN_MONTH -> "${period / MILLISECONDS_IN_DAY} дн. назад"
        period < MILLISECONDS_IN_YEAR -> "${period / MILLISECONDS_IN_MONTH} мес. назад"
        else -> "${period / MILLISECONDS_IN_YEAR} г. назад"
    }
}