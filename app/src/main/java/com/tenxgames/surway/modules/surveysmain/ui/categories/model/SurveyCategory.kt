package com.tenxgames.surway.modules.surveysmain.ui.categories.model

import android.os.Parcel
import android.os.Parcelable
import com.tenxgames.surway.modules.surveysmain.data.model.SurveyCategoryEntity
import com.tenxgames.surway.utils.toCreatedDateString

data class SurveyCategory(
    val id: Long,
    val name: String,
    val description: String,
    val imageUrl: String,
    val trend: Double,
    val updated: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readDouble(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(imageUrl)
        parcel.writeDouble(trend)
        parcel.writeString(updated)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SurveyCategory> {
        override fun createFromParcel(parcel: Parcel): SurveyCategory {
            return SurveyCategory(parcel)
        }

        override fun newArray(size: Int): Array<SurveyCategory?> {
            return arrayOfNulls(size)
        }
    }
}

fun SurveyCategoryEntity.toPresentation() =
    SurveyCategory(
        id = this.id,
        name = this.name,
        description = this.description,
        imageUrl = this.imageUrl,
        trend = this.trend,
        updated = this.updated.toCreatedDateString()
    )